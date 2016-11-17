package training.derivative.model.entity.insurance.impl.personal;

import training.derivative.model.entity.insurance.impl.AbstractInsurance;

/**
 * This class represents common state and functionality of person insurance entity
 *
 * @author oleksij.onysymchuk@gmail
 * @version 1.0 17 NOV 2016
 */
public class AbstractPersonalInsurance extends AbstractInsurance {
    /**
     * Full name of person to be insured by this insurance
     */
    protected String insuredPersonFullName;

    /**
     * Initializes only the super instance
     */
    public AbstractPersonalInsurance() {
    }

    /**
     * Initializes the super instance and all fields
     *
     * @param id                    Unique serial number of insurance
     * @param name                  Insurance name
     * @param sumInsured            The value of sum insured
     * @param riskDegree            The value of risk degree
     * @param insuredPersonFullName Full name of person to be insured by this insurance
     */
    public AbstractPersonalInsurance(int id, String name, long sumInsured, double riskDegree, String insuredPersonFullName) {
        super(id, name, sumInsured, riskDegree);
        this.insuredPersonFullName = insuredPersonFullName;
    }

    public String getInsuredPersonFullName() {
        return insuredPersonFullName;
    }

    public void setInsuredPersonFullName(String insuredPersonFullName) {
        this.insuredPersonFullName = insuredPersonFullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        AbstractPersonalInsurance that = (AbstractPersonalInsurance) o;

        return insuredPersonFullName != null ? insuredPersonFullName.equals(that.insuredPersonFullName) : that.insuredPersonFullName == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (insuredPersonFullName != null ? insuredPersonFullName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", insuredPersonFullName='" + insuredPersonFullName + "'";
    }
}
