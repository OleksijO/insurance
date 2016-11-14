package training.insurance.model.init;

import java.math.BigDecimal;

/**
 * Created by oleksij.onysymchuk@gmail on 14.11.2016.
 */
public enum BaseInsurance {
    A(1, 1500, 0.05),
    B(2, 45800, 0.005),
    C(3, 1450000, 0.001),
    D(4, 135000, 0.02),
    E(5, 1234567.89, 0.045);
    private int id;
    private BigDecimal sumInsured;
    private double riskDegree;


    BaseInsurance(int id, double sumInsured, double riskDegree) {
        this.id = id;
        this.sumInsured = new BigDecimal(sumInsured);
        this.riskDegree = riskDegree;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    public double getRiskDegree() {
        return riskDegree;
    }
}
