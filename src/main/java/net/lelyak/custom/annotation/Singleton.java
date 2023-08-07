package net.lelyak.custom.annotation;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Nazar Lelyak.
 */
@Retention(RUNTIME)
public @interface Singleton {
    boolean lazy() default false;
}
