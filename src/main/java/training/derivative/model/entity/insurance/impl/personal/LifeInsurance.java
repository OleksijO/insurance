package training.derivative.model.entity.insurance.impl.personal;

/**
 * This class represents person life insurance entity
 *
 * @author oleksij.onysymchuk@gmail
 * @version 1.0 17 NOV 2016
 */
public class LifeInsurance extends AbstractPersonalInsurance {
    public static final String NAME = "Life BaseInsurance";
    /**
     * The period of insurance availability
     */
    private int insuredPeriod;

    /**
     * Initializes field name with system constant
     */
    public LifeInsurance() {
        this.name = NAME;
    }

    /**
     * Initializes the instance fields with specified values
     *
     * @param id            Unique serial number of insurance
     * @param sumInsured    The value of sum insured
     * @param riskDegree    The value of risk degree
     * @param insuredPersonFullName Full name of person to be insured by this insurance
     * @param insuredPeriod The period of insurance availability
     */
    public LifeInsurance(int id, long sumInsured, double riskDegree, String insuredPersonFullName, int insuredPeriod) {
        super(id, NAME, sumInsured, riskDegree, insuredPersonFullName);
        this.insuredPeriod = insuredPeriod;
    }

    public int getInsuredPeriod() {
        return insuredPeriod;
    }

    public void setInsuredPeriod(int insuredPeriod) {
        this.insuredPeriod = insuredPeriod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        LifeInsurance that = (LifeInsurance) o;

        return insuredPeriod == that.insuredPeriod;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + insuredPeriod;
        return result;
    }

    @Override
    public String toString() {
        return "LifeInsurance{" +
                super.toString() +
                ", insuredPeriod=" + insuredPeriod +
                "}";
    }


}
