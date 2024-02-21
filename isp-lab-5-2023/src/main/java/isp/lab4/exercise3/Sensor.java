package isp.lab4.exercise3;

public abstract class Sensor {
    private String instalLocation;
    private String name;

    public String getInstalLocation() {
        return instalLocation;
    }

    public String getName() {
        return name;
    }

    public void setInstalLocation(String instalLocation) {
        this.instalLocation = instalLocation;
    }

    public void setName(String name) {
        this.name = name;
    }
}
