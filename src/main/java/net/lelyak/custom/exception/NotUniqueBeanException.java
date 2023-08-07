package net.lelyak.custom.exception;

/**
 * @author Nazar Lelyak.
 */
public class NotUniqueBeanException extends RuntimeException {

    public NotUniqueBeanException() {
        super("more than one implementation is presented");
    }

    public <T> NotUniqueBeanException(Class<T> type) {
        super(String.format("%s has more than one impl. Thus, please update your config", type));
    }
}
