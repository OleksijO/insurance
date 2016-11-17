package training.derivative.model.entity.insurance.impl.find.condition;

import training.derivative.model.entity.insurance.Insurance;
import training.derivative.model.entity.derivative.InsuranceFindCondition;

import java.util.function.Predicate;

/**
 * Created by oleksij.onysymchuk@gmail on 17.11.2016.
 */
public class SumInsuredRange implements InsuranceFindCondition {
    final private Predicate<Insurance> predicate;

    public SumInsuredRange(long min, long max) {
        this.predicate = insurance -> ((insurance.getSumInsured()>=min) && (insurance.getSumInsured()<=max));
    }

    @Override
    public Predicate<Insurance> getPredicate() {
        return predicate;
    }
}
