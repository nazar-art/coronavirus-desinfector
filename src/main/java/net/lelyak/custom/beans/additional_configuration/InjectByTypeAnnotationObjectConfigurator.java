package net.lelyak.custom.beans.additional_configuration;

import lombok.SneakyThrows;
import net.lelyak.custom.annotation.InjectByType;
import net.lelyak.custom.context.ApplicationContext;

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
