package net.lelyak;

import net.lelyak.custom.context.Application;
import net.lelyak.custom.context.ApplicationContext;
import net.lelyak.model.Room;
import net.lelyak.service.desinfector.CoronaDesinfector;
import net.lelyak.service.policeman.Policeman;
import net.lelyak.service.policeman.PolicemanImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nazar Lelyak.
 */
public class AppDemo {
    public static void main(String[] args) {
        // get rid of this line
        // CoronaDesinfector desinfector = ObjectFactory.getInstance().createObject(CoronaDesinfector.class);

        ApplicationContext context = Application.run(
                "net.lelyak",
                new HashMap<>(Map.of(Policeman.class, PolicemanImpl.class))
//                new HashMap<>(Map.of(Policeman.class, AngryPoliceman.class))
        );
        CoronaDesinfector desinfector = context.getObject(CoronaDesinfector.class);
        desinfector.startDesinfection(new Room());
    }
}
