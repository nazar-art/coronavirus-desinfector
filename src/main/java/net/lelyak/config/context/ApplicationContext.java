package net.lelyak.config.context;

import lombok.Getter;
import lombok.Setter;
import net.lelyak.config.Config;
import net.lelyak.model.annotation.Singleton;
import net.lelyak.config.factory.ObjectFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Nazar Lelyak.
 */
public class ApplicationContext {
    @Getter
    private Config config;
    @Setter
    private ObjectFactory factory;
    @Getter
    private Map<Class, Object> cache = new ConcurrentHashMap<>();

    public ApplicationContext(Config config) {
        this.config = config;
    }

    @SuppressWarnings("unchecked")
    public <T> T getObject(Class<T> type) {

        if (cache.containsKey(type)) {
            T t = (T) cache.get(type);
            System.out.println("get INSTANCE from CACHE: " + t);
            return t;
        }

        Class<? extends T> implClass = type;

        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }
        T t = factory.createObject(implClass);

        if (implClass.isAnnotationPresent(Singleton.class)) {
            cache.put(type, t);
        }

        return t;
    }
}
