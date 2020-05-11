package net.lelyak;

import net.lelyak.model.annotation.InjectByType;
import net.lelyak.service.announcer.Announcer;
import net.lelyak.service.policeman.Policeman;
import net.lelyak.model.Room;

/**
 * @author Nazar Lelyak.
 */

public class CoronaDesinfector {

    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policeman;


    public void start(Room room) {
        announcer.announce("Desinfaction will be started - all have to leave this place !!");
        policeman.makePeopleLeaveRoom();
        desinfect(room);
        announcer.announce("You could go back now");
    }

    private void desinfect(Room room){
        System.out.println("magic is going: 'корона изыди!' - virus will go away :-)");
    }
}
