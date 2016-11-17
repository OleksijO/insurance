package training.derivative;

import training.derivative.model.Model;
import training.derivative.model.entity.Insurance;
import training.derivative.model.entity.InsuranceDerivative;
import training.derivative.model.entity.insurance.find.condition.RiskDegreeRange;
import training.derivative.model.entity.insurance.find.condition.SumInsuredRange;
import training.derivative.model.init.InitInsurance;

import java.util.ArrayList;
import java.util.List;

import static training.derivative.model.entity.InsuranceSortMethod.BY_RISK_DEGREE;

/**
 * This class represents Controller unit of MVC based architecture of program "Insurances".
 *
 * @author oleksij.onysymchuk@gmail
 * @version 1.0 14 NOV 2016
 */
public class Controller {

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
        List<Insurance> insurances = inputInsuranceData();
        InsuranceDerivative derivative = model.createDerivative("Ivan Sidorov", insurances);
        view.showMessage("Constructed derivative from initial sorces: ");
        view.showMessage("");
        view.showMessage(derivative.toString());
        view.showMessage("");
        view.showMessage("Sorting insurances by risk degree: ");
        view.showMessage("");
        derivative.sortInsurances(BY_RISK_DEGREE);
        view.showMessage("Derivative with sorted insurances by risk degree:");
        view.showMessage(derivative.toString());
        view.showMessage("");
        view.showMessage("Find insurances in derivative with ( 0.007 <= risk degree <= 0.012 ) and " +
                " ( 5000000 <= sun insured <= 6000000" );
        view.showMessage("");
        view.showMessage(derivative.findInsurances(
                new RiskDegreeRange(0.007, 0.012), new SumInsuredRange(5000000, 6000000))
                .toString());
        //Predicate<Insurance>
        //derivative.getInsurances().stream().
    }

    private List<Insurance> inputInsuranceData() {
        List<Insurance> insurances = new ArrayList<>();
        for (InitInsurance initInsurance : InitInsurance.values()) {
            insurances.add(initInsurance.getInsurance());
        }
        return insurances;
    }


}
