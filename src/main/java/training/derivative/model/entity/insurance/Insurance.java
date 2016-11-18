package training.derivative.model.entity.insurance;

/**
 * This interface describes Insurance object common interface.
 * This interface is used to access parameters of insure, which needed in program.
 * For simplicity you can use toString method to view it's content.
 * Described methods are used in out of package environment.
 *
 * @author oleksij.onysymchuk@gmail
 * @version 1.0 17 NOV 2016
 */
public interface Insurance {

    /**
     * @return The value of insurance sum insured
     */
    long getSumInsured();

    /**
     * @return The value of insurance risk degree
     */
    double getRiskDegree();

    /**
     * @return The value of insurance fee
     */
    long getFee();



}
