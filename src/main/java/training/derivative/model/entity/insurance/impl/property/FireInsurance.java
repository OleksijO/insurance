package training.derivative.model.entity.insurance.impl.property;

import training.derivative.model.entity.insurance.impl.AbstractInsurance;

/**
 * Created by oleksij.onysymchuk@gmail on 13.11.2016.
 */
public class FireInsurance extends AbstractInsurance {
    public static final String NAME= "Fire BaseInsurance";
    private String address;

    public FireInsurance() {
        this.name=NAME;
    }

    public FireInsurance(String address) {
        this();
        this.address = address;
    }

    public FireInsurance(int id,long sumInsured, double riskDegree, String address) {
        super(id, NAME,sumInsured, riskDegree);
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
                "} " ;
    }
}
