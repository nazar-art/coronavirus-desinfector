package net.lelyak.service.recomendator;

import net.lelyak.custom.annotation.InjectProperty;
import net.lelyak.custom.annotation.Singleton;

/**
 * @author Nazar Lelyak.
 */
//@Singleton(lazy = true)
@Singleton
//@Deprecated
public class RecommendatorImpl implements Recommendator {
    @InjectProperty("drink")
    private String alcohol;

    public RecommendatorImpl() {
        System.out.println("recommendator was created");
    }

    @Override
    @Deprecated
    public void recommend() {
        System.out.println("for proper protection from Covid-2019, you should drink: " + alcohol);
    }

    @Override
    public String toString() {
        return "RecommendatorImpl{" +
                "alcohol='" + alcohol + '\'' +
                '}';
    }
}
