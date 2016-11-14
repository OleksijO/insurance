package training.insurance.model.init;

/**
 * Created by oleksij.onysymchuk@gmail on 14.11.2016.
 */
public enum CarNumber {
    A("AA 1001 AA"),
    B("AA 1111 AA"),
    C("AA 1010 AA");

    private String number;

    CarNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
