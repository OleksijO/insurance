package training.derivative.model.entity.insurance.responsibility;

import training.derivative.model.entity.insurance.AbstractInsurance;

import java.util.List;

/**
 * Created by oleksij.onysymchuk@gmail on 13.11.2016.
 */
public class CTPInsurance extends AbstractInsurance {
    public static final String NAME = "Compulsory Third Party BaseInsurance";
    private String carNumber;
    private List<String> drivers;

    public CTPInsurance() {
        this.name = NAME;
    }

    public CTPInsurance(String carNumber, List<String> drivers) {
        this();
        this.carNumber = carNumber;
        this.drivers = drivers;
    }

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
