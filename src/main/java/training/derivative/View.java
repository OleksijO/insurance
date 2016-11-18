package training.derivative;

/**
 * This class represents View unit of MVC based architecture of program "Insurances".
 *
 * @author oleksij.onysymchuk@gmail
 * @version 1.0 14 NOV 2016
 */
public class View {
    public static final String EMPTY = "";
    public static final String DERIVATIVE_CONSTRUCTED = "Constructed derivative from initial sources: ";
    public static final String RISK_DEGREE_SORTING = "Sorting insurances by risk degree: ";
    public static final String SORTED_INSURANCES_DERIVATIVE = "Derivative with sorted insurances by risk degree:";
    public static final String FIND_INSURANCES_WITH_CONDITION =            "Find insurances in derivative with ( 0.007 <= risk degree <= 0.012 ) and " +                    " ( 5000000 <= sun insured <= 6000000";
    public static final String FOUNDED_INSURANCES = "Insurances with matching criteria:";
    /**
     * Shows specified message on standart out
     *
     * @param message the text to be shown
     */
    public void showMessage(String message) {
        printMessage(message);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

}
