package isp.lab10.exercise1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ATC {
    private List<AircraftThread> aircraftThreads;

    public ATC() {
        aircraftThreads = new ArrayList<>();
    }

    public void execute(AtcCommand atcCommand) {
        if (atcCommand instanceof TakeoffCommand) {
            TakeoffCommand takeoffCommand = (TakeoffCommand) atcCommand;
            int altitude = takeoffCommand.getAltitude();
            if (altitude < 1000) {
                System.out.println("Invalid altitude. Minimum altitude for takeoff is 1000 meters.");
                return;
            }
        }
    }

    // Modify the sendCommand() method in ATC class
    public void sendCommand(String aircraftId, AtcCommand cmd) {
        Aircraft aircraft = getAircraftById(aircraftId);
        if (aircraft == null) {
            System.out.println("Aircraft not found.");
            return;
        }

        synchronized (aircraft) {
            aircraft.execute(cmd);
            aircraft.notify(); // Notify the aircraft thread of the command
        }
    }

    public void addAircraft(String id) {
        Aircraft aircraft = new Aircraft(id);
        AircraftThread aircraftThread = new AircraftThread(aircraft);
        aircraftThreads.add(aircraftThread);
        aircraftThread.start();
        System.out.println("Aircraft " + id + " added.");
    }
    public void showAircrafts() {
        System.out.println("Aircrafts:");
        for (AircraftThread aircraftThread : aircraftThreads) {
            Aircraft aircraft = aircraftThread.getAircraft();
            System.out.println("- " + aircraft.getId());
        }
    }
    private Aircraft getAircraftById(String aircraftId) {
        for (AircraftThread aircraftThread : aircraftThreads) {
            Aircraft aircraft = aircraftThread.getAircraft();
            if (aircraft.getId().equals(aircraftId)) {
                return aircraft;
            }
        }
        return null;
    }
    public void create(AtcCommand atcCommand) {
        // Create ATC command
    }
}

