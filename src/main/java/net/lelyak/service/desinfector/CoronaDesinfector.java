package net.lelyak.service.desinfector;

import net.lelyak.custom.annotation.InjectByType;
import net.lelyak.model.Room;
import net.lelyak.service.announcer.Announcer;
import net.lelyak.service.policeman.Policeman;

/**
 * @author Nazar Lelyak.
 */

public class CoronaDesinfector implements Desinfector {

    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policeman;

    @Override
    public void startDesinfection(Room room) {
        announcer.announce("Desinfaction will be started - all have to leave this place !!");
        policeman.makePeopleLeaveRoom();
        desinfect(room);
        announcer.announce("Desinfaction is over. You could go back now");
    }

    private void desinfect(Room room) {
        System.out.println("Desinfection in progress - virus will go away soon :-)");
    }
}
