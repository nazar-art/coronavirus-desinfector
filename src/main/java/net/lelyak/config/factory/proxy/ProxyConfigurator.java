package net.lelyak.config.factory.proxy;

/**
 * @author Nazar Lelyak.
 */
public interface ProxyConfigurator {
    Object replaceWithProxyIfNeeded(Object t, Class implClass);
}
