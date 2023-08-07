package net.lelyak.custom.beans.proxy;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Nazar Lelyak.
 */
public class DeprecatedHandlerProxyConfigurator implements ProxyConfigurator {
    @Override
    public Object replaceWithProxyIfNeeded(Object t, Class implClass) {

        //+ make support for @Deprecate above methods, not class
        for (Method declaredMethod : implClass.getDeclaredMethods()) {
            if (declaredMethod.isAnnotationPresent(Deprecated.class)) {

                if (proxyForObjectWithoutInterfaces(t, implClass))
                    return Enhancer.create(implClass,
                            (net.sf.cglib.proxy.InvocationHandler) (proxy, method, args) -> getInvocationHandlerLogic(method, args, t));

                return Proxy.newProxyInstance(implClass.getClassLoader(),
                        implClass.getInterfaces(), (proxy, method, args) -> getInvocationHandlerLogic(method, args, t));
            }
        }

        if (implClass.isAnnotationPresent(Deprecated.class)) {

            if (proxyForObjectWithoutInterfaces(t, implClass))
                return Enhancer.create(implClass,
                        (net.sf.cglib.proxy.InvocationHandler) (proxy, method, args) -> getInvocationHandlerLogic(method, args, t));

            return Proxy.newProxyInstance(implClass.getClassLoader(),
                    implClass.getInterfaces(), (proxy, method, args) -> getInvocationHandlerLogic(method, args, t));
        } else {
            return t;
        }

    }

    private boolean proxyForObjectWithoutInterfaces(Object t, Class implClass) {
        return implClass.getInterfaces().length == 0;
    }

    private Object getInvocationHandlerLogic(Method method, Object[] args, Object t) throws IllegalAccessException, InvocationTargetException {
        System.out.println("********** What are you doing! This is deprecated! **********");
        return method.invoke(t, args);
    }
}
