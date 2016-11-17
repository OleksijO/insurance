package training.derivative.model;

import training.derivative.model.entity.Insurance;
import training.derivative.model.entity.InsuranceDerivative;
import training.derivative.model.entity.derivative.InsuranceDerivativeImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents Model unit of MVC based architecture of program.
 *
 * @author oleksij.onysymchuk@gmail
 * @version 1.0 14 NOV 2016
 */
public class Model {
    List<Insurance> insurances = new ArrayList<>();

    public InsuranceDerivative createDerivative(String insurantName, List<Insurance> insurances) {
        return new InsuranceDerivativeImpl(insurantName, insurances);
    }
}
