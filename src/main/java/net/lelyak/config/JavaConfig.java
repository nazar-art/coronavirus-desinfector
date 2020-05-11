package net.lelyak.config;

import lombok.Getter;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

/**
 * @author Nazar Lelyak.
 */
public class JavaConfig implements Config {

    @Getter
    private Reflections scanner;
    private Map<Class, Class> interface2ImplClass;

    public JavaConfig(String packageToScan, Map<Class, Class> interface2ImplClass) {
        this.interface2ImplClass = interface2ImplClass;
        this.scanner = new Reflections(packageToScan);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> Class<? extends T> getImplClass(Class<T> interfaceType) {
        return interface2ImplClass.computeIfAbsent(interfaceType, aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(interfaceType);
            if (classes.size() != 1) {
                throw new RuntimeException(interfaceType + " has 0 or more than one impl please update your config");
            }

            return classes.iterator().next();
        });

    }
}












