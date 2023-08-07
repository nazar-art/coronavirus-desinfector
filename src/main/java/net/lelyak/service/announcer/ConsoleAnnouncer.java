package net.lelyak.service.announcer;

import net.lelyak.custom.annotation.InjectByType;
import net.lelyak.service.recomendator.Recommendator;

/**
 * @author Nazar Lelyak.
 */
public class ConsoleAnnouncer implements Announcer {
    @InjectByType
    private Recommendator recommendator;

    @Override
    public void announce(String message) {
        System.out.println(message);
        recommendator.recommend();
    }
}
