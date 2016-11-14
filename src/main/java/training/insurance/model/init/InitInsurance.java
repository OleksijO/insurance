package training.insurance.model.init;

import training.insurance.model.entity.insurance.AbstractInsurance;
import training.insurance.model.entity.insurance.personal.LifeInsurance;
import training.insurance.model.entity.insurance.personal.MedicalInsurance;
import training.insurance.model.entity.insurance.property.CASCOInsurance;
import training.insurance.model.entity.insurance.property.FireInsurance;
import training.insurance.model.entity.insurance.responsibility.CTPInsurance;

/**
 * Created by oleksij.onysymchuk@gmail on 14.11.2016.
 */
public enum InitInsurance {
    A(new LifeInsurance(
            BaseInsurance.values()[0].getId(),
            BaseInsurance.values()[0].getSumInsured(),
            BaseInsurance.values()[0].getRiskDegree(),
            Name.values()[0].getName(),
            10)),
    B(new MedicalInsurance(
            BaseInsurance.values()[1].getId(),
            BaseInsurance.values()[1].getSumInsured(),
            BaseInsurance.values()[1].getRiskDegree(),
            Name.values()[1].getName(),
            "Clinics")),
    C(new CASCOInsurance(
            BaseInsurance.values()[2].getId(),
            BaseInsurance.values()[2].getSumInsured(),
            BaseInsurance.values()[2].getRiskDegree(),
            CarNumber.values()[0].getNumber())),
    D(new FireInsurance(
            BaseInsurance.values()[3].getId(),
            BaseInsurance.values()[3].getSumInsured(),
            BaseInsurance.values()[3].getRiskDegree(),
            Address.values()[0].getAddress())),
    E(new CTPInsurance(
            BaseInsurance.values()[2].getId(),
            BaseInsurance.values()[2].getSumInsured(),
            BaseInsurance.values()[2].getRiskDegree(),
            CarNumber.values()[1].getNumber()));

    private AbstractInsurance insurance;

    InitInsurance(AbstractInsurance insurance) {
        this.insurance = insurance;
    }

    public AbstractInsurance getInsurance() {
        return insurance;
    }
}
