package training.insurance.model.init;

/**
 * Created by oleksij.onysymchuk@gmail on 14.11.2016.
 */
public enum Name {
    A("Ivanov Ivan"),
    B("Petro Petrov"),
    C("Sidor Sidorov"),
    D("Ivan Petrov"),
    E("Petro Ivanov");

    private String name;

    Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
