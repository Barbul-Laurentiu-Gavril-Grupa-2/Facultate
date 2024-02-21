package aut.isp.lab4.exercise5;

public class Sensor {
    private String manufacturer;
    public String model;

    @Override
    public String toString() {
        return "Sensor{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
