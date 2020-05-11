package net.lelyak.config.application;

import net.lelyak.config.JavaConfig;
import net.lelyak.config.factory.ObjectFactory;

import java.util.Map;

/**
 * @author Nazar Lelyak.
 */
public class Application {
    public static ApplicationContext run(String packageToScan, Map<Class, Class> interface2ImplClass) {
        JavaConfig config = new JavaConfig(packageToScan, interface2ImplClass);
        ApplicationContext context = new ApplicationContext(config);
        ObjectFactory objectFactory = new ObjectFactory(context);
        //todo homework - init all singletons which are not lazy
        context.setFactory(objectFactory);
        return context;
    }
}
