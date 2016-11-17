package training.derivative.model.entity.insurance.impl.personal;

/**
 * Created by oleksij.onysymchuk@gmail on 13.11.2016.
 */
public class LifeInsurance extends AbstractPersonalInsurance {
    public static final String NAME = "Life BaseInsurance";
    private int insuredPeriod;

    public LifeInsurance() {
        this.name = NAME;
    }

    public LifeInsurance(int insuredPeriod) {
        this();
        this.insuredPeriod = insuredPeriod;
    }

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
