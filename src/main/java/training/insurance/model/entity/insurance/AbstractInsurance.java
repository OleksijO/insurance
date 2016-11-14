package training.insurance.model.entity.insurance;

import training.insurance.model.entity.Insurance;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;

/**
 * Created by oleksij.onysymchuk@gmail on 13.11.2016.
 */
abstract public class AbstractInsurance implements Insurance {
    protected int id;
    protected String name;
    protected BigDecimal sumInsured;
    protected double riskDegree;

    public AbstractInsurance() {
    }

    public AbstractInsurance(int id, String name, BigDecimal sumInsured, double riskDegree) {
        this.id = id;
        this.name = name;
        this.sumInsured = sumInsured;
        this.riskDegree = riskDegree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(BigDecimal sumInsured) {
        this.sumInsured = sumInsured;
    }

    @Override
    public double getRiskDegree() {
        return riskDegree;
    }

    public void setRiskDegree(double riskDegree) {
        this.riskDegree = riskDegree;
    }

    @Override
    public BigDecimal getFee() {
        return sumInsured.multiply(new BigDecimal(riskDegree)).setScale(2, ROUND_HALF_UP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractInsurance that = (AbstractInsurance) o;

        if (id != that.id) return false;
        if (Double.compare(that.riskDegree, riskDegree) != 0) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return sumInsured != null ? sumInsured.equals(that.sumInsured) : that.sumInsured == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sumInsured != null ? sumInsured.hashCode() : 0);
        temp = Double.doubleToLongBits(riskDegree);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", sumInsured=" + sumInsured +
                ", riskDegree=" + riskDegree;
    }
}
