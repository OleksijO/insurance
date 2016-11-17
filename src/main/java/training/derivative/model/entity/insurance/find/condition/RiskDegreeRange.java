package training.derivative.model.entity.insurance.find.condition;

import training.derivative.model.entity.insurance.Insurance;
import training.derivative.model.entity.insurance.InsuranceFindCondition;

import java.util.function.Predicate;

/**
 * This class is a condition container for predicate, which is used for filtering insurances
 * by the value of risk degree and specified range of this value. Bounds are included.
 * Instances with risk degree values within the range are considered to be find by this condition.
 *
 * @author oleksij.onysymchuk@gmail
 * @version 1.0 17 NOV 2016
 */
public class RiskDegreeRange implements InsuranceFindCondition {
    final private Predicate<Insurance> predicate;

    /**
     * Initializes filter range of this condition. Bounds are included.
     *
     * @param min lower bound of filter range
     * @param max upper bound of filter range
     */
    public RiskDegreeRange(double min, double max) {
        this.predicate = insurance -> ((insurance.getRiskDegree() >= min) && (insurance.getRiskDegree() <= max));
    }

    @Override
    public Predicate<Insurance> getPredicate() {
        return predicate;
    }
}
