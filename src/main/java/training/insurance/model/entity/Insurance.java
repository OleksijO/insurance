package training.insurance.model.entity;

import java.math.BigDecimal;

/**
 * Created by oleksij.onysymchuk@gmail on 13.11.2016.
 */
public interface Insurance {

    BigDecimal getSumInsured();

    double getRiskDegree();

    BigDecimal getFee();



}
