package isp.lab6.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        // Create VehicleRegistry object
        VehicleRegistry registry = new VehicleRegistry();

        // Create and add vehicles to the registry
        Vehicle vehicle1 = new Vehicle("1A2B3C4D5E6F7G8H", "ABC123", "Toyota", "Corolla", 2022);
        registry.addVehicle(vehicle1);

        Vehicle vehicle2 = new Vehicle("9I8H7G6F5E4D3C2B1A", "XYZ789", "Honda", "Accord", 2021);
        registry.addVehicle(vehicle2);

        // Display the list of vehicles in the registry
        System.out.println("List of Vehicles in the Registry:");
        registry.displayVehicles();

        // Remove a vehicle from the registry
        String vinToRemove = "1A2B3C4D5E6F7G8H";
        registry.removeVehicle(vinToRemove);

        // Check if a vehicle with a given VIN is in the registry
        String vinToCheck = "9I8H7G6F5E4D3C2B1A";
        boolean isVehicleInRegistry = registry.isVehicleInRegistry(vinToCheck);
        System.out.println("Is Vehicle in Registry? " + isVehicleInRegistry);

        // Display the updated list of vehicles in the registry
        System.out.println("\nUpdated List of Vehicles in the Registry:");
        registry.displayVehicles();
    }
}
