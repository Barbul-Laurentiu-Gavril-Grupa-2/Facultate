package aut.isp.lab4.exercise4;

public class AquariumController {

    //attributs
    private FishFeeder feeder =new FishFeeder() ;
    private String manufacturer;
    private String model;
    private float curentTime;
    private float feedingTime;
    private LightsController lightsController = new LightsController();
    //constructors
    //methods

    public void setCurentTime(float curentTime) {

        this.curentTime = curentTime;
        if (this.feedingTime == this.curentTime) {
            feeder.feed();
        }
        boolean lightOn = lightsController.isLight();
        boolean shouldBeOn = (this.curentTime >= lightsController.getStartTime()) && (this.curentTime <= lightsController.getEndTime());

        if (shouldBeOn && !lightOn) {
            lightsController.setLight(true);
        } else if (!shouldBeOn && lightOn) {
            lightsController.setLight(false);
        }
    }

    public LightsController getLightsController() {
        return lightsController;
    }

    public void setFeedingTime(float feedingTime) {
        this.feedingTime = feedingTime;
    }

    @Override
    public String toString() {
        return "AquariumController{" + "feeder=" + feeder + ", manufacturer='" + manufacturer + '\'' + ", model='" + model + '\'' + ", curentTime=" + curentTime + ", feedingTime=" + feedingTime + ", lightsController=" + lightsController + '}';
    }
}

