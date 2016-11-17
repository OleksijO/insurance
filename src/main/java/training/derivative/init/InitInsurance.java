package training.derivative.init;

import training.derivative.model.entity.insurance.impl.AbstractInsurance;
import training.derivative.model.entity.insurance.impl.personal.LifeInsurance;
import training.derivative.model.entity.insurance.impl.personal.MedicalInsurance;
import training.derivative.model.entity.insurance.impl.property.CASCOInsurance;
import training.derivative.model.entity.insurance.impl.property.FireInsurance;
import training.derivative.model.entity.insurance.impl.responsibility.CTPInsurance;

/**
 * This enum contains data and is used to replace user input for test or demonstration purposes.
 *
 * @version 1.0 17 NOV 2016
 * @author oleksij.onysymchuk@gmail
 */
public enum InitInsurance {
    A(new LifeInsurance(
            1,
            100000000,
            0.01,
            "Ivan Ivanov",
            10)),
    B(new MedicalInsurance(
            2,
            10000000,
            0.03,
            "Petro Petrov",
            "Clinics Medical")),
    C(new CASCOInsurance(
            3,
            1500000,
            0.08,
            "AA 000 AA")),
    D(new FireInsurance(
            4,
            500000000,
            0.005,
            "Kiev, Peremohy ave, 37")),
    E(new CTPInsurance(
            5,
            5100000,
            0.0097,
            "AA 0000 AA"));

    private AbstractInsurance insurance;

    InitInsurance(AbstractInsurance insurance) {
        this.insurance = insurance;
    }

    public AbstractInsurance getInsurance() {
        return insurance;
    }
}
