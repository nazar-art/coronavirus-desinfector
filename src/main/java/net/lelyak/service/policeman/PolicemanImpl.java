package net.lelyak.service.policeman;

import net.lelyak.custom.annotation.InjectByType;
import net.lelyak.custom.annotation.Primary;
import net.lelyak.service.recomendator.Recommendator;

import javax.annotation.PostConstruct;

/**
 * @author Nazar Lelyak.
 */
@Primary
public class PolicemanImpl implements Policeman {

    @InjectByType
    private Recommendator recommendator;

    @PostConstruct
    public void init() {
        System.out.println("recommendator class is: " + recommendator.getClass());
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("Please leave the room.");
    }
}
