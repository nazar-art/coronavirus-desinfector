package net.lelyak.custom.beans.additional_configuration;

import lombok.Cleanup;
import lombok.SneakyThrows;
import net.lelyak.custom.annotation.InjectProperty;
import net.lelyak.custom.context.ApplicationContext;

import java.io.BufferedReader;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

/**
 * @author Nazar Lelyak.
 */
public class InjectPropertyAnnotationObjectConfigurator implements ObjectConfigurator {

    private final Map<String, String> propertiesMap;

    @SneakyThrows
    public InjectPropertyAnnotationObjectConfigurator() {
        String path = ClassLoader.getSystemClassLoader().getResource("application.properties").getPath();
        @Cleanup
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(path));
        Stream<String> lines = bufferedReader.lines();
        propertiesMap = lines.map(line -> line.split("="))
                .collect(toMap(arr -> arr[0], arr -> arr[1]));
    }

    @Override
    @SneakyThrows
    public void configure(Object t, ApplicationContext context) {
        Class<?> implClass = t.getClass();
        for (Field field : implClass.getDeclaredFields()) {
            InjectProperty annotation = field.getAnnotation(InjectProperty.class);
            if (annotation != null) {
                String value = annotation.value().isEmpty()
                        ? propertiesMap.get(field.getName())
                        : propertiesMap.get(annotation.value());
                field.setAccessible(true);
                field.set(t, value);
            }
        }
    }
}
