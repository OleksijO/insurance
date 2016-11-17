package training.derivative;

/**
 * This class represents View unit of MVC based architecture of program.
 * It contains text constants for output messages and methods to show certain blocks of game information.
 *
 * @version 1.0 14 NOV 2016
 * @author oleksij.onysymchuk@gmail
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
