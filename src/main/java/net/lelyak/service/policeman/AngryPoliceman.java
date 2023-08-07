package net.lelyak.service.policeman;

/**
 * @author Nazar Lelyak.
 */
public class AngryPoliceman implements Policeman {
    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("Leave the room! Hurry up bastards! Otherwise, I will kick your ass ...");
    }
}
