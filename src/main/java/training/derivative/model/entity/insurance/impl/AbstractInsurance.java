package training.derivative.model.entity.insurance.impl;

import training.derivative.model.entity.insurance.Insurance;

/**
 * This class represents common state and functionality of insurance entity
 *
 * @author oleksij.onysymchuk@gmail
 * @version 1.0 17 NOV 2016
 */
abstract public class AbstractInsurance implements Insurance {
    /**
     * Unique serial number of insurance
     */
    protected int id;
    /**
     * Insurance name
     */
    protected String name;
    /**
     * The value of sum insured
     */
    protected long sumInsured;
    /**
     * The value of risk degree
     */
    protected double riskDegree;

    /**
     * Initializes only the super instance
     */
    public AbstractInsurance() {
    }

    /**
     * Initializes fields
     *
     * @param id         Unique serial number of insurance
     * @param name       Insurance name
     * @param sumInsured The value of sum insured
     * @param riskDegree The value of risk degree
     */
    public AbstractInsurance(int id, String name, long sumInsured, double riskDegree) {
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
    public long getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(long sumInsured) {
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
    public long getFee() {
        return (long) (sumInsured * riskDegree);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractInsurance that = (AbstractInsurance) o;

        if (id != that.id) return false;
        if (sumInsured != that.sumInsured) return false;
        if (Double.compare(that.riskDegree, riskDegree) != 0) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) (sumInsured ^ (sumInsured >>> 32));
        temp = Double.doubleToLongBits(riskDegree);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", sumInsured=" + sumInsured + " cents" +
                ", riskDegree=" + riskDegree;
    }
}
