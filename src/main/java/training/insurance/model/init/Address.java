package training.insurance.model.init;

/**
 * Created by oleksij.onysymchuk@gmail on 14.11.2016.
 */
public enum Address {
    A("Kiev, Perevogy ave., 37");

    private String address;

    Address(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
