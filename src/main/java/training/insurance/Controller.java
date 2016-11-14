package training.insurance;

import training.insurance.model.Model;
import training.insurance.model.entity.Insurance;
import training.insurance.model.entity.InsuranceDerivative;
import training.insurance.model.init.InitInsurance;
import training.insurance.model.init.Name;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents Controller unit of MVC based architecture of program "Insurances".
 *
 * @version 1.0 14 NOV 2016
 * @author oleksij.onysymchuk@gmail
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
     * @param view reference to view unit of application
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
        InsuranceDerivative derivative = model.createDerivative(Name.values()[2].getName(), insurances);
        view.showMessage("Constructed derivative: ");
        view.showMessage(derivative.toString());
        view.showMessage("Sorting insurances by risk degree: ");
        derivative.sortInsurancesByRiskDegree();
        view.showMessage("Derivative with sorted insurances by risk degree:");
        view.showMessage(derivative.toString());
    }

    private List<Insurance> inputInsuranceData() {
        List<Insurance> insurances = new ArrayList<>();
        for(InitInsurance initInsurance: InitInsurance.values()){
            insurances.add(initInsurance.getInsurance());
        }
        return insurances;
    }


}