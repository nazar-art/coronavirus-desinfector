package net.lelyak.custom.beans.additional_configuration;

import net.lelyak.custom.context.ApplicationContext;

/**
 * @author Nazar Lelyak.
 */
public interface ObjectConfigurator {
    void configure(Object t, ApplicationContext context);
}
