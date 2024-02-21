package isp.lab4.exercise2;

public class SmartWatch implements Chargeable{
    private int batteryLevel;
    public SmartWatch(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
    public int getBatteryLevel() {
        return batteryLevel;
    }
    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
    public void charge(int durationMinutes) {
        // Calculate the battery level increment based on the charging rate (20% in 10 minutes)
        int batteryIncrement = (durationMinutes / 10) * 20;

        // Update the battery level while ensuring it does not exceed the maximum level of 100
        batteryLevel = Math.min(batteryLevel + batteryIncrement, 100);
    }
}
