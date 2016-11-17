package training.derivative.model.entity.insurance.impl.property;

import training.derivative.model.entity.insurance.impl.AbstractInsurance;

/**
 * This class represents fire insurance entity
 *
 * @author oleksij.onysymchuk@gmail
 * @version 1.0 17 NOV 2016
 */
public class FireInsurance extends AbstractInsurance {
    public static final String NAME = "Fire BaseInsurance";
    /**
     * Address of property to be insured by this insurance
     */
    private String address;

    /**
     * Initializes field name with system constant
     */
    public FireInsurance() {
        this.name = NAME;
    }

    /**
     * Initializes the instance fields with specified values
     *
     * @param id         Unique serial number of insurance
     * @param sumInsured The value of sum insured
     * @param riskDegree The value of risk degree
     * @param address    Address of property to be insured by this insurance
     */
    public FireInsurance(int id, long sumInsured, double riskDegree, String address) {
        super(id, NAME, sumInsured, riskDegree);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        FireInsurance that = (FireInsurance) o;

        return address != null ? address.equals(that.address) : that.address == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FireInsurance{" +
                super.toString() +
                ", address='" + address + '\'' +
                "} ";
    }
}
