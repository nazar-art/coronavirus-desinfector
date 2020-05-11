package net.lelyak.service.policeman;

/**
 * @author Nazar Lelyak.
 */
public class AngryPoliceman implements Policeman {
    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("Всех убью! Вон пошли");
    }
}
