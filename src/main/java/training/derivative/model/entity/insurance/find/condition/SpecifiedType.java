package training.derivative.model.entity.insurance.find.condition;

import training.derivative.model.entity.insurance.Insurance;
import training.derivative.model.entity.insurance.InsuranceFindCondition;

import java.util.function.Predicate;

/**
 * This class is a condition container for predicate, which is used for filtering insurances
 * by the type (simple class name). Instances of specified class are considered to be find by this condition.
 *
 * @author oleksij.onysymchuk@gmail
 * @version 1.0 17 NOV 2016
 */
public class SpecifiedType implements InsuranceFindCondition {
    final private Predicate<Insurance> predicate;

    public SpecifiedType(String type) {
        this.predicate = insurance -> (insurance.getClass().getSimpleName().equals(type));
    }

    @Override
    public Predicate<Insurance> getPredicate() {
        return predicate;
    }
}
