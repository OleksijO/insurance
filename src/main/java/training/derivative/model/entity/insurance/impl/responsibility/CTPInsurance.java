package training.derivative.model.entity.insurance.impl.responsibility;

import training.derivative.model.entity.insurance.impl.AbstractInsurance;

import java.util.List;

/**
 * This class represents Compulsory Third Party insurance entity
 *
 * @author oleksij.onysymchuk@gmail
 * @version 1.0 17 NOV 2016
 */
public class CTPInsurance extends AbstractInsurance {
    public static final String NAME = "Compulsory Third Party Insurance";
    /**
     * Insured car number
     */
    private String carNumber;
    /**
     * Possible driver list for which this insurance is available. May be empty.
     */
    private List<String> drivers;

    /**
     * Initializes field name with system constant
     */
    public CTPInsurance() {
        this.name = NAME;
    }

    /**
     * Initializes the instance fields with specified values
     *
     * @param id         Unique serial number of insurance
     * @param sumInsured The value of sum insured
     * @param riskDegree The value of risk degree
     * @param carNumber  Insured car number
     * @param drivers    Possible driver list for which this insurance is available. May be null.
     */
    public CTPInsurance(int id, long sumInsured, double riskDegree, String carNumber, List<String> drivers) {
        super(id, NAME, sumInsured, riskDegree);
        this.carNumber = carNumber;
        this.drivers = drivers;
    }

    public CTPInsurance(int id, long sumInsured, double riskDegree, String carNumber) {
        super(id, NAME, sumInsured, riskDegree);
        this.carNumber = carNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CTPInsurance that = (CTPInsurance) o;

        if (carNumber != null ? !carNumber.equals(that.carNumber) : that.carNumber != null) return false;
        return drivers != null ? drivers.equals(that.drivers) : that.drivers == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (carNumber != null ? carNumber.hashCode() : 0);
        result = 31 * result + (drivers != null ? drivers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CTPInsurance{" +
                super.toString() +
                ", carNumber='" + carNumber + '\'' +
                ", drivers=" + drivers +
                "} ";
    }
}
