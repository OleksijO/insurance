package training.derivative.model.entity.insurance.impl.find.condition;

import training.derivative.model.entity.insurance.Insurance;
import training.derivative.model.entity.derivative.InsuranceFindCondition;

import java.util.function.Predicate;

/**
 * Created by oleksij.onysymchuk@gmail on 17.11.2016.
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
