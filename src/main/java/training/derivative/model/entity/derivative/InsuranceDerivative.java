package training.derivative.model.entity.derivative;

import training.derivative.model.entity.insurance.Insurance;
import training.derivative.model.entity.insurance.InsuranceSortMethod;

import java.util.List;
import java.util.function.Predicate;

/**
 * This interface describes Derivative - container for several Insurances.
 * For simplicity you can use toString method to view it's content.
 *
 * @author oleksij.onysymchuk@gmail
 * @version 1.0 17 NOV 2016
 */
public interface InsuranceDerivative {

    /**
     * Calculates and returns summary fee of all insurances.
     *
     * @return Summaty fee of all insurances of derivative
     */
    long getSummaryFee();

    /**
     * Adds notNull insurance to derivative's insurance list.
     * In case of null - does nothing.
     *
     * @param insurance Insurance to be added.
     */
    void addInsurance(Insurance insurance);

    /**
     * @return Derivative Insurance List
     */
    List<Insurance> getInsurances();

    /**
     * Sorts Derivative's insurance list with specified method
     *
     * @param method one of enum's {@link InsuranceSortMethod} values
     */
    void sortInsurances(InsuranceSortMethod method);

    /**
     * Returns the list of insurances, which satisfy vararg specified condition list.
     * Returns all insurances in case of null or empty parameters. Null conditions are ignored.
     *
     * @param predicate Predicate to filter insurances.
     * @return Filtered insurance list
     */
    List<Insurance> findInsurances(Predicate<Insurance> predicate);

}
