package net.lelyak.config;

import org.reflections.Reflections;

/**
 * @author Nazar Lelyak.
 */
public interface Config {
    <T> Class<? extends T> getImplClass(Class<T> interfaceType);

    Reflections getScanner();
}
