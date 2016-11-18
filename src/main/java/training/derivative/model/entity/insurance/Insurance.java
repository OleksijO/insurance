package training.derivative.model.entity.insurance;

/**
 * This interface describes Insurance object common interface.
 * For simplicity you can use toString method to view it's content.
 * Described methods are used in out of package environment.
 *
 * @author oleksij.onysymchuk@gmail
 * @version 1.0 17 NOV 2016
 */
public interface Insurance {

    long getSumInsured();

    double getRiskDegree();

    long getFee();



}
