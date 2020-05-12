package net.lelyak.service.recomendator;

import net.lelyak.model.annotation.InjectProperty;
import net.lelyak.model.annotation.Singleton;

/**
 * @author Nazar Lelyak.
 */
//@Singleton(lazy = true)
@Singleton
//@Deprecated
public class RecommendatorImpl implements Recommendator {

    @InjectProperty("whisky")
    private String alcohol;

    public RecommendatorImpl() {
        System.out.println("recommendator was created");
    }

    @Override
    @Deprecated
    public void recommend() {
        System.out.println("to protect from covid-2019, drink "+alcohol);
    }

    @Override
    public String toString() {
        return "RecommendatorImpl{" +
                "alcohol='" + alcohol + '\'' +
                '}';
    }
}
