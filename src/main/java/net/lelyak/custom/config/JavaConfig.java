package net.lelyak.custom.config;

import lombok.Getter;
import net.lelyak.custom.annotation.Primary;
import net.lelyak.custom.exception.NoSuchBeanException;
import net.lelyak.custom.exception.NotUniqueBeanException;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

/**
 * @author Nazar Lelyak.
 */
public class JavaConfig implements Config {

    @Getter
    private final Reflections scanner;
    private final Map<Class<?>, Class> interface2ImplClass;

    /*public JavaConfig(String packageToScan) {
        this.interface2ImplClass = new HashMap<>();
        this.scanner = new Reflections(packageToScan);
    }*/

    public JavaConfig(String packageToScan, Map<Class<?>, Class> interface2ImplClass) {
        this.interface2ImplClass = interface2ImplClass;
        this.scanner = new Reflections(packageToScan);
    }


    @Override
    @SuppressWarnings("unchecked")
    public <T> Class<? extends T> getImplClass(Class<T> interfaceType) {
        return interface2ImplClass.computeIfAbsent(interfaceType, aClass -> {

            Set<Class<? extends T>> classes = scanner.getSubTypesOf(interfaceType);
            int classesCount = classes.size();

            if (classesCount == 0) {
                throw new NoSuchBeanException(interfaceType);
            }

            if (classesCount > 1) {
                for (Class<? extends T> clazz : classes) {
                    if (clazz.isAnnotationPresent(Primary.class)) {
                        return clazz;
                    }
                }
                throw new NotUniqueBeanException(interfaceType);
            }

            return classes.iterator().next();
        });
    }
}












