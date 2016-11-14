package training.insurance.model.entity.insurance.personal;

import java.math.BigDecimal;

/**
 * Created by oleksij.onysymchuk@gmail on 13.11.2016.
 */
public class MedicalInsurance extends AbstractPersonalInsurance {
    public static final String NAME = "Medical BaseInsurance";
    private String clinicsName;

    public MedicalInsurance() {
        this.name = NAME;
    }

    public MedicalInsurance(String clinicsName) {
        this();
        this.clinicsName = clinicsName;
    }

    public MedicalInsurance(int id, BigDecimal sumInsured, double riskDegree, String insuredPersonFullName, String clinicsName) {
        super(id, NAME, sumInsured, riskDegree, insuredPersonFullName);
        this.clinicsName = clinicsName;
    }

    public String getClinicsName() {
        return clinicsName;
    }

    public void setClinicsName(String clinicsName) {
        this.clinicsName = clinicsName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MedicalInsurance that = (MedicalInsurance) o;

        return clinicsName != null ? clinicsName.equals(that.clinicsName) : that.clinicsName == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (clinicsName != null ? clinicsName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MedicalInsurance{" +
                super.toString() +
                ", clinicsName='" + clinicsName + '\'' +
                "} ";
    }
}
