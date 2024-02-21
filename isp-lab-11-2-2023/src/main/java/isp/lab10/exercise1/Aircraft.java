package isp.lab10.exercise1;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Aircraft implements Runnable {
    private String id;
    private int altitude;
    private AircraftState state;

    public Aircraft(String id) {
        this.id = id;
        this.altitude = 0;
        this.state = AircraftState.ON_STAND;
    }

    public String getId() {
        return id;
    }

    public int getAltitude() {
        return altitude;
    }

    public AircraftState getState() {
        return state;
    }

    public void receiveAtcMessage(AtcMessage msg) {
        // Process ATC messages if required
    }

    public void execute(AtcCommand atcCommand) {
        // Execute ATC commands
    }

    @Override
    public void run() {
        // Perform aircraft operations
    }
}
