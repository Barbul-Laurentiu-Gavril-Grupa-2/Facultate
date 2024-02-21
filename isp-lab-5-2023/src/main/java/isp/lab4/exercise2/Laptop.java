package isp.lab4.exercise2;

public class Laptop implements Chargeable{
    private int batteryLevel;
    public Laptop(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
    public int getBatteryLevel() {
        return batteryLevel;
    }
    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
    public void charge(int durationMinutes) {
        // Calculate the battery level increment based on the charging rate (10% in 10 minutes)
        int batteryIncrement = (durationMinutes / 10) * 10;

        // Update the battery level while ensuring it does not exceed the maximum level of 100
        batteryLevel = Math.min(batteryLevel + batteryIncrement, 100);
         }
    }
