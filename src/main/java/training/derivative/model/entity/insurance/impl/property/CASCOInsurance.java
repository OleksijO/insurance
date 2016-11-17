package training.derivative.model.entity.insurance.impl.property;

import training.derivative.model.entity.insurance.impl.AbstractInsurance;

/**
 * This class represents CASCO insurance entity
 *
 * @author oleksij.onysymchuk@gmail
 * @version 1.0 17 NOV 2016
 */
public class CASCOInsurance extends AbstractInsurance {
    public static final String NAME = "Casualty and Collision BaseInsurance";
    /**
     * Insured car number
     */
    private String carNumber;

    /**
     * Initializes field name with system constant
     */
    public CASCOInsurance() {
        this.name = NAME;
    }

    /**
     * Initializes the instance fields with specified values
     *
     * @param id         Unique serial number of insurance
     * @param sumInsured The value of sum insured
     * @param riskDegree The value of risk degree
     * @param carNumber  Insured car number
     */
    public CASCOInsurance(int id, long sumInsured, double riskDegree, String carNumber) {
        super(id, NAME, sumInsured, riskDegree);
        this.carNumber = carNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CASCOInsurance that = (CASCOInsurance) o;

        return carNumber != null ? carNumber.equals(that.carNumber) : that.carNumber == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (carNumber != null ? carNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CASCOInsurance{" +
                super.toString() +
                ", carNumber='" + carNumber + '\'' +
                "} ";
    }
}
