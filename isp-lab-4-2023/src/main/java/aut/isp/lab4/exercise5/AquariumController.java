package aut.isp.lab4.exercise5;

public class AquariumController {

    //attributs
    private FishFeeder feeder = new FishFeeder();
    private String manufacturer;
    private String model;
    private float curentTime;
    private float feedingTime;
    //constructors
    //methods

    public void setCurentTime(float curentTime) {

        this.curentTime = curentTime;
        if (this.feedingTime == this.curentTime) {
            feeder.feed();

        }
    }
        public void setFeedingTime(float feedingTime){
            this.feedingTime = feedingTime;
        }
}

