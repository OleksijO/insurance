package training.derivative.model.entity.insurance.find.condition;

import training.derivative.model.entity.insurance.Insurance;
import training.derivative.model.entity.insurance.InsuranceFindCondition;

import java.util.function.Predicate;

/**
 * This class is a condition container for predicate, which is used for filtering insurances
 * by the value of sum insured and specified range of this value. Bounds are included.
 * Instances with sun insured values within the range are considered to be find by this condition.
 *
 * @author oleksij.onysymchuk@gmail
 * @version 1.0 17 NOV 2016
 */
public class SumInsuredRange implements InsuranceFindCondition {
    final private Predicate<Insurance> predicate;

    public SumInsuredRange(long min, long max) {
        this.predicate = insurance -> ((insurance.getSumInsured() >= min) && (insurance.getSumInsured() <= max));
    }

    @Override
    public Predicate<Insurance> getPredicate() {
        return predicate;
    }
}
