package training.derivative.model.entity.insurance;

import java.util.function.Predicate;

/**
 * This interface describes condition object for filtering insurances in list.
 * It is a container for filter predicate.
 *
 * @author oleksij.onysymchuk@gmail
 * @version 1.0 17 NOV 2016
 */
public interface InsuranceFindCondition {

    /**
     * @return Predicate, which is used in stream filter
     */
    Predicate<Insurance> getPredicate();

}
