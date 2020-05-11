package net.lelyak.config.factory.object;

import net.lelyak.config.application.ApplicationContext;

/**
 * @author Nazar Lelyak.
 */
public interface ObjectConfigurator {
    void configure(Object t, ApplicationContext context);
}
