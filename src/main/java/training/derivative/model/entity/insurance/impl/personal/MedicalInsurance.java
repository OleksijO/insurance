package training.derivative.model.entity.insurance.impl.personal;

/**
 * This class represents person medical insurance entity
 *
 * @author oleksij.onysymchuk@gmail
 * @version 1.0 17 NOV 2016
 */
public class MedicalInsurance extends AbstractPersonalInsurance {
    public static final String NAME = "Medical BaseInsurance";
    /**
     * Insurance provider clinics name
     */
    private String clinicsName;

    /**
     * Initializes field name with system constant
     */
    public MedicalInsurance() {
        this.name = NAME;
    }

    public MedicalInsurance(String clinicsName) {
        this();
        this.clinicsName = clinicsName;
    }

    /**
     * Initializes the instance fields with specified values
     *
     * @param id                    Unique serial number of insurance
     * @param sumInsured            The value of sum insured
     * @param riskDegree            The value of risk degree
     * @param insuredPersonFullName Full name of person to be insured by this insurance
     * @param clinicsName           Insurance provider clinics name
     */
    public MedicalInsurance(int id, long sumInsured,
                            double riskDegree, String insuredPersonFullName, String clinicsName) {
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
