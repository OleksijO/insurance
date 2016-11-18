package training.derivative;

import training.derivative.init.InitInsurance;
import training.derivative.model.Model;
import training.derivative.model.entity.derivative.InsuranceDerivative;
import training.derivative.model.entity.derivative.impl.InsuranceDerivativeImpl;
import training.derivative.model.entity.insurance.Insurance;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static training.derivative.View.*;
import static training.derivative.model.entity.insurance.InsuranceSortMethod.BY_RISK_DEGREE;

/**
 * This class represents Controller unit of MVC based architecture of program "Insurances".
 *
 * @author oleksij.onysymchuk@gmail
 * @version 1.0 14 NOV 2016
 */
public class Controller {
    private static final String SIDOROV = "Ivan Sidorov";


    /**
     * Reference to model unit of MVC based architecture of program
     */
    private Model model;
    /**
     * Reference to view unit of MVC based architecture of program
     */
    private View view;

    /**
     * Initiates program's controller unit and set up references to model and view units
     *
     * @param model reference to model unit of application
     * @param view  reference to view unit of application
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * runs main program cycle
     */
    public void processUser() {
        /* Emulation user input data */
        List<Insurance> insurances = inputInsuranceData();
        InsuranceDerivative derivative = new InsuranceDerivativeImpl(SIDOROV, insurances);

        view.showMessage(DERIVATIVE_CONSTRUCTED);
        view.showMessage(EMPTY);
        view.showMessage(derivative.toString());
        view.showMessage(EMPTY);

        /* Emulation of sort by risk degree menu item */
        view.showMessage(RISK_DEGREE_SORTING);
        view.showMessage(EMPTY);
        derivative.sortInsurances(BY_RISK_DEGREE);

        view.showMessage(SORTED_INSURANCES_DERIVATIVE);
        view.showMessage(derivative.toString());
        view.showMessage(EMPTY);

        /* Emulation of find by range criteria menu item */
        view.showMessage(FIND_INSURANCES_WITH_CONDITION);
        view.showMessage(EMPTY);
        Predicate<Insurance> condition = i -> (i.getRiskDegree() > 0.007) && (i.getRiskDegree() < 0.012);
        condition = condition.and(i -> i.getSumInsured() >= 5000000 && i.getSumInsured() <= 6000000);

        view.showMessage(FOUNDED_INSURANCES);
        view.showMessage(EMPTY);
        view.showMessage(derivative.findInsurances(condition).toString());

    }

    private List<Insurance> inputInsuranceData() {
        List<Insurance> insurances = new ArrayList<>();
        for (InitInsurance initInsurance : InitInsurance.values()) {
            insurances.add(initInsurance.getInsurance());
        }
        return insurances;
    }


}
