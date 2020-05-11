package net.lelyak.service.policeman;

import net.lelyak.model.annotation.InjectByType;
import net.lelyak.service.recomendator.Recommendator;

import javax.annotation.PostConstruct;

/**
 * @author Nazar Lelyak.
 */
public class PolicemanImpl implements Policeman {

    @InjectByType
    private Recommendator recommendator;

    @PostConstruct
    public void init() {
        System.out.println(recommendator.getClass());
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("пиф паф, бах бах, кыш, кыш!");
    }
}
