package net.lelyak.custom.exception;

/**
 * @author Nazar Lelyak.
 */
public class NoSuchBeanException extends RuntimeException {
    public <T> NoSuchBeanException(Class<T> type) {
        super(String.format("%s has ZERO implementation", type));
    }
}
