package training.insurance.model.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by oleksij.onysymchuk@gmail on 13.11.2016.
 */
public interface InsuranceDerivative {

    BigDecimal getSummaryFee();

    List<Insurance> getInsurances();

    void sortInsurancesByRiskDegree();

    void addInsurance(Insurance insurance);

}
