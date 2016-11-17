package training.derivative.model.entity.insurance.find.condition;

import training.derivative.model.entity.Insurance;
import training.derivative.model.entity.InsuranceFindCondition;

import java.util.function.Predicate;

/**
 * Created by oleksij.onysymchuk@gmail on 17.11.2016.
 */
public class RiskDegreeRange implements InsuranceFindCondition {
    final private Predicate<Insurance> predicate;

    public RiskDegreeRange(double min, double max) {
        this.predicate = insurance -> ((insurance.getRiskDegree()>=min) && (insurance.getRiskDegree()<=max));
    }

    @Override
    public Predicate<Insurance> getPredicate() {
        return predicate;
    }
}
