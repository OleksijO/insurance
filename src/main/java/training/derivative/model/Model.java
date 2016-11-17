package training.derivative.model;

import training.derivative.model.entity.derivative.InsuranceDerivative;
import training.derivative.model.entity.derivative.impl.InsuranceDerivativeImpl;
import training.derivative.model.entity.insurance.Insurance;

import java.util.List;

/**
 * This class represents Model unit of MVC based architecture of program.
 *
 * @author oleksij.onysymchuk@gmail
 * @version 1.0 14 NOV 2016
 */
public class Model {

    public InsuranceDerivative createDerivative(String insurantName, List<Insurance> insurances) {
        return new InsuranceDerivativeImpl(insurantName, insurances);
    }

}
