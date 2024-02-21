package isp.lab8.airways;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RouteManagementApp {
    private static final String ROUTES_DIRECTORY = "routes/";

    public static void main(String[] args) {

        createRoutesDirectory();

        while (true) {
            System.out.println("Route Management Application");
            System.out.println("1. Create a new route");
            System.out.println("2. Delete a route");
            System.out.println("3. List all routes");
            System.out.println("4. Load a route");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(getUserInput());

                switch (choice) {
                    case 1:
                        createRoute();
                        break;
                    case 2:
                        deleteRoute();
                        break;
                    case 3:
                        listRoutes();
                        break;
                    case 4:
                        loadRoute();
                        break;
                    case 5:
                        System.out.println("Exiting the application...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }

            System.out.println();
        }
    }

    private static void createRoutesDirectory() {
        File routesDirectory = new File(ROUTES_DIRECTORY);
        if (!routesDirectory.exists()) {
            routesDirectory.mkdir();
        }
    }

    private static void createRoute() {
        System.out.println("Creating a new route...");

        try {
            System.out.print("Enter route name: ");
            String routeName = getUserInput();

            File routeDirectory = new File(ROUTES_DIRECTORY + routeName);
            if (routeDirectory.exists()) {
                System.out.println("Route already exists.");
                return;
            }

            if (!routeDirectory.mkdir()) {
                System.out.println("Failed to create route directory.");
                return;
            }

            List<Waypoint> waypoints = new ArrayList<>();

            while (true) {
                System.out.println("Add a new waypoint to the route:");
                Waypoint waypoint = createWaypoint();
                waypoints.add(waypoint);

                System.out.print("Add another waypoint? (y/n): ");
                String choice = getUserInput();
                if (!choice.equalsIgnoreCase("y")) {
                    break;
                }
            }

            saveRoute(routeName, waypoints);

            System.out.println("Route created successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred while creating the route: " + e.getMessage());
        }
    }

    private static Waypoint createWaypoint() throws IOException {
        System.out.print("Enter waypoint name: ");
        String name = getUserInput();
        System.out.print("Enter latitude: ");
        double latitude = Double.parseDouble(getUserInput());
        System.out.print("Enter longitude: ");
        double longitude = Double.parseDouble(getUserInput());
        System.out.print("Enter altitude: ");
        int altitude = Integer.parseInt(getUserInput());

        return new Waypoint(name, latitude, longitude, altitude);
    }

    private static void addWaypoint(String routeName, String name, double latitude, double longitude, int altitude) throws IOException {
        Waypoint waypoint = new Waypoint(name, latitude, longitude, altitude);
        String routeDirectoryPath = ROUTES_DIRECTORY + routeName + "/";
        int waypointIndex = getWaypointCount(routeName) + 1;
        String waypointFilename = routeName + "_" + waypointIndex + ".ser";
        saveWaypointToFile(waypoint, routeDirectoryPath + waypointFilename);
        System.out.println("Waypoint added successfully.");
    }

    private static int getWaypointCount(String routeName) {
        File routeDirectory = new File(ROUTES_DIRECTORY + routeName);
        File[] waypointFiles = routeDirectory.listFiles();
        if (waypointFiles != null) {
            return waypointFiles.length;
        }
        return 0;
    }

    private static void saveRoute(String routeName, List<Waypoint> waypoints) throws IOException {
        String routeDirectoryPath = ROUTES_DIRECTORY + routeName + "/";

        for (int i = 0; i < waypoints.size(); i++) {
            Waypoint waypoint = waypoints.get(i);
            String waypointFilename = routeName + "_" + (i + 1) + ".ser";
            saveWaypointToFile(waypoint, routeDirectoryPath + waypointFilename);
        }
    }

    private static void saveWaypointToFile(Waypoint waypoint, String filename) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(waypoint);
        out.close();
        fileOut.close();
    }

    private static void deleteRoute() throws IOException {
        System.out.println("Deleting a route...");

        System.out.print("Enter route name: ");
        String routeName = getUserInput();

        File routeDirectory = new File(ROUTES_DIRECTORY + routeName);
        if (!routeDirectory.exists()) {
            System.out.println("Route does not exist.");
            return;
        }

        File[] waypointFiles = routeDirectory.listFiles();
        if (waypointFiles != null) {
            for (File file : waypointFiles) {
                file.delete();
            }
        }

        if (routeDirectory.delete()) {
            System.out.println("Route deleted successfully.");
        } else {
            System.out.println("Failed to delete route.");
        }
    }

    private static void listRoutes() {
        System.out.println("Listing all routes...");

        File routesDirectory = new File(ROUTES_DIRECTORY);
        File[] routeDirectories = routesDirectory.listFiles();
        if (routeDirectories != null) {
            for (File route : routeDirectories) {
                System.out.println(route.getName());
            }
        } else {
            System.out.println("No routes found.");
        }
    }

    private static void loadRoute() throws IOException {
        System.out.println("Loading a route...");

        System.out.print("Enter route name: ");
        String routeName = getUserInput();

        File routeDirectory = new File(ROUTES_DIRECTORY + routeName);
        if (!routeDirectory.exists()) {
            System.out.println("Route does not exist.");
            return;
        }

        File[] waypointFiles = routeDirectory.listFiles();
        if (waypointFiles == null || waypointFiles.length == 0) {
            System.out.println("No waypoints found for this route.");
            return;
        }

        List<Waypoint> waypoints = new ArrayList<>();
        for (File file : waypointFiles) {
            Waypoint waypoint = loadWaypointFromFile(file);
            if (waypoint != null) {
                waypoints.add(waypoint);
            }
        }

        if (!waypoints.isEmpty()) {
            double totalDistance = calculateTotalDistance(waypoints);
            System.out.println("Total distance: " + totalDistance + " kilometers");

            System.out.println("Waypoints:");
            for (Waypoint waypoint : waypoints) {
                System.out.println(waypoint.getName() + ": " + waypoint.getLatitude() + "° N, " +
                        waypoint.getLongitude() + "° E, " + waypoint.getAltitude() + " meters altitude");
            }
        } else {
            System.out.println("Failed to load waypoints for this route.");
        }
    }

    private static Waypoint loadWaypointFromFile(File file) throws IOException {
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        try {
            Object object = in.readObject();
            if (object instanceof Waypoint) {
                return (Waypoint) object;
            } else {
                System.out.println("Invalid file format: " + file.getName());
                return null;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load waypoint from file: " + file.getName());
            return null;
        } finally {
            in.close();
            fileIn.close();
        }
    }

    private static double calculateTotalDistance(List<Waypoint> waypoints) {
        double totalDistance = 0;

        for (int i = 0; i < waypoints.size() - 1; i++) {
            Waypoint currentWaypoint = waypoints.get(i);
            Waypoint nextWaypoint = waypoints.get(i + 1);
            double distance = calculateDistance(currentWaypoint.getLatitude(), currentWaypoint.getLongitude(),
                    nextWaypoint.getLatitude(), nextWaypoint.getLongitude());
            totalDistance += distance;
        }

        return totalDistance;
    }

    private static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        int earthRadius = 6371; // Radius of the Earth in kilometers
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return earthRadius * c;
    }

    private static String getUserInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}
