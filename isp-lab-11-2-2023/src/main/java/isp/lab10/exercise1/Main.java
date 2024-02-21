package isp.lab10.exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ATC atc = new ATC();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command (ADD, TAKEOFF, LAND, SHOW, EXIT):");
            String command = scanner.nextLine();

            switch (command.toUpperCase()) {
                case "ADD":
                    System.out.println("Enter aircraft ID:");
                    String aircraftId = scanner.nextLine();
                    atc.addAircraft(aircraftId);
                    break;
                case "TAKEOFF":
                    System.out.println("Enter aircraft ID:");
                    String takeoffAircraftId = scanner.nextLine();
                    System.out.println("Enter altitude:");
                    int takeoffAltitude = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    AtcCommand takeoffCommand = new TakeoffCommand(takeoffAltitude);
                    atc.sendCommand(takeoffAircraftId, takeoffCommand);
                    break;
                case "LAND":
                    System.out.println("Enter aircraft ID:");
                    String landAircraftId = scanner.nextLine();
                    AtcCommand landCommand = new LandCommand();
                    atc.sendCommand(landAircraftId, landCommand);
                    break;
                case "SHOW":
                    atc.showAircrafts();
                    break;
                case "EXIT":
                    System.exit(0);
                default:
                    System.out.println("Invalid command. Try again.");
                    break;
            }
        }
    }
}