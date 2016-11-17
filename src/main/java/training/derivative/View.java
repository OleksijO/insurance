package training.derivative;

/**
 * This class represents View unit of MVC based architecture of program "Insurances".
 *
 * @author oleksij.onysymchuk@gmail
 * @version 1.0 14 NOV 2016
 */
public class View {

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
