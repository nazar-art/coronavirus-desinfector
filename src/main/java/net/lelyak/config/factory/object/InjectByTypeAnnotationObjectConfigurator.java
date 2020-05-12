package net.lelyak.config.factory.object;

import lombok.SneakyThrows;
import net.lelyak.config.context.ApplicationContext;
import net.lelyak.model.annotation.InjectByType;

import java.lang.reflect.Field;

/**
 * @author Nazar Lelyak.
 */
public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object t, ApplicationContext context) {
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                field.setAccessible(true);
                Object object = context.getObject(field.getType());
                field.set(t, object);
            }
        }
    }
}
