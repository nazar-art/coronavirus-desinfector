package net.lelyak.custom.annotation;/**
 * @author Nazar Lelyak.
 */

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface InjectProperty {
    String value() default "";
}
