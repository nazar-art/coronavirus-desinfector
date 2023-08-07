package net.lelyak.custom.beans.proxy;

/**
 * @author Nazar Lelyak.
 */
public interface ProxyConfigurator {
    Object replaceWithProxyIfNeeded(Object t, Class implClass);
}
