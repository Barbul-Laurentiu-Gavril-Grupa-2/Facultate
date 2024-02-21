package aut.isp.lab4.exercise3;

public class AquariumController {

    //attributs
    private FishFeeder fishFeeder;
    private String manufacturer;
    private String model;
    private float curentTime;
    private float feedingTime;
    //constructors
    //methods

    public void setCurentTime(float curentTime) {

        this.curentTime = curentTime;
        if(this.feedingTime==2.30)
            this.fishFeeder.feed();

    }

    public void setFeedingTime(float feedingTime) {
        this.feedingTime = feedingTime;
    }

    @Override
    public String toString() {
        return "AquariumController{" +
                "feeder=" + fishFeeder +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", curentTime=" + curentTime +
                ", feedingTime=" + feedingTime +
                '}';
    }
}
