package net.lelyak;

import net.lelyak.config.application.Application;
import net.lelyak.config.application.ApplicationContext;
import net.lelyak.service.policeman.Policeman;
import net.lelyak.service.policeman.PolicemanImpl;
import net.lelyak.model.Room;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nazar Lelyak.
 */
public class Main {
    public static void main(String[] args) {
//        CoronaDesinfector desinfector = ObjectFactory.getInstance().createObject(CoronaDesinfector.class);
        ApplicationContext context = Application.run("net.lelyak", new HashMap<>(Map.of(Policeman.class, PolicemanImpl.class)));
        CoronaDesinfector desinfector = context.getObject(CoronaDesinfector.class);
        desinfector.start(new Room());
    }
}
