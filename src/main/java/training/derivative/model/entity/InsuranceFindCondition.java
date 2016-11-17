package training.derivative.model.entity;

import java.util.function.Predicate;

/**
 * Created by oleksij.onysymchuk@gmail on 17.11.2016.
 */
public interface InsuranceFindCondition {

    Predicate<Insurance> getPredicate();

}
