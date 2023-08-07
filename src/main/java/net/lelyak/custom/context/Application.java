package net.lelyak.custom.context;

import net.lelyak.custom.annotation.Singleton;
import net.lelyak.custom.beans.factory.ObjectFactory;
import net.lelyak.custom.config.JavaConfig;
import org.reflections.Reflections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Nazar Lelyak.
 */
public class Application {
    public static ApplicationContext run(String packageToScan, Map<Class<?>, Class> interface2ImplClass) {
        JavaConfig config = new JavaConfig(packageToScan, interface2ImplClass);
        ApplicationContext context = new ApplicationContext(config);
        ObjectFactory objectFactory = new ObjectFactory(context);

        // init all singletons which are not lazy
        Map<Class<?>, Object> beans = initNotLazySingletons(packageToScan, config, objectFactory);
        context.getCache().putAll(beans);
        System.out.println("save to context following singletons: " + beans);

        context.setFactory(objectFactory);
        return context;
    }

    private static Map<Class<?>, Object> initNotLazySingletons(String packageToScan, JavaConfig config, ObjectFactory objectFactory) {
        Reflections scanner = new Reflections(packageToScan);
        Set<Class<?>> allSingletons = scanner.getTypesAnnotatedWith(Singleton.class);

        Map<Class<?>, Object> result = new HashMap<>();
        for (Class<?> type : allSingletons) {
            Singleton annotation = type.getAnnotation(Singleton.class);
            if (annotation.lazy()) {
                return Collections.emptyMap();
            }

            if (type.isInterface()) {
                Class<?> implClass = config.getImplClass(type);
                result.put(type, objectFactory.createObject(implClass));
            }
            result.put(type, objectFactory.createObject(type));
        }
        return result;
    }
}
