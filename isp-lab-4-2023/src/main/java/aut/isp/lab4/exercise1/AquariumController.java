package aut.isp.lab4.exercise1;

public class AquariumController {

    //attributs
    private String manufacturer;
    private String model;
    private float curentTime;
    //constructors
    //methods

    public void setCurentTime(float curentTime) {
        this.curentTime = curentTime;
    }

    @Override
    public String toString() {
        return "AquariumController{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", curentTime=" + curentTime +
                '}';
    }
}
