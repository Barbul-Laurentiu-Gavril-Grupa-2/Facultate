package aut.isp.lab4.exercise4;

public class LightsController {
    private boolean light = false;
    private float startTime;
    private float endTime;
    private int time = 8;

    public void setLight(boolean light) {
        this.light = light;
        if (this.light == true)
            System.out.println("Sa aprins becul");
        else
            System.out.println("S-a oprit becul");
    }

    public float getEndTime() {
        return endTime;
    }

    public float getStartTime() {

        return startTime;
    }

    public void setEndStartTime(float startTime) {
        this.startTime = startTime;
        this.endTime = startTime + time;
    }

    public boolean isLight() {
        return light;
    }

    @Override
    public String toString() {
        return "LightsController{" +
                "light=" + light +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", time=" + time +
                '}';
    }
}
