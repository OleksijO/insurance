package training.derivative.model.entity;

import java.util.List;

/**
 * This interface describes Derivative - container for several Insurances.
 *
 * @author oleksij.onysymchuk@gmail
 * @version 1.0 17 NOV 2016
 */
public interface InsuranceDerivative {

    /**
     * Calculates summary fee of all insurances
     *
     * @return
     */
    long getSummaryFee();

    void addInsurance(Insurance insurance);

    List<Insurance> getInsurances();

    void sortInsurances(InsuranceSortMethod method);

    List<Insurance> findInsurances(InsuranceFindCondition... conditions);

}
