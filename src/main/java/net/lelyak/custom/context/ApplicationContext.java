package net.lelyak.custom.context;

import lombok.Getter;
import lombok.Setter;
import net.lelyak.custom.annotation.Singleton;
import net.lelyak.custom.beans.factory.ObjectFactory;
import net.lelyak.custom.config.Config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Nazar Lelyak.
 */
public class ApplicationContext {
    @Getter
    private final Config config;
    @Getter
    private final Map<Class<?>, Object> cache = new ConcurrentHashMap<>();
    @Setter
    private ObjectFactory factory;

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
