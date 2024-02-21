package isp.lab10.exercise1;

public class AircraftThread extends Thread {
    private Aircraft aircraft;

    public AircraftThread(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    @Override
    public void run() {
        aircraft.run();
    }
}
