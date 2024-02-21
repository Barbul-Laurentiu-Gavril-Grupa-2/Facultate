package isp.lab7.safehome;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SafeHome {

    public static void main(String[] args) {
        // Create door and access logs
        Door door = new Door();
        List<AccessLog> accessLogs = new ArrayList<>();

        // Create door lock controller
        DoorLockController controller = new DoorLockController(door, accessLogs);

        // Create scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt for user type selection
        System.out.println("Select user type:");
        System.out.println("1. Admin");
        System.out.println("2. Tenant");
        System.out.print("Enter your choice: ");
        int userTypeChoice = scanner.nextInt();

        switch (userTypeChoice) {
            case 1:
                handleAdminUser(controller, scanner);
                break;
            case 2:
                handleTenantUser(controller, scanner);
                break;
            default:
                System.out.println("Invalid choice. Exiting the program.");
        }

        // Close the scanner
        scanner.close();
    }

    private static void handleAdminUser(DoorLockController controller, Scanner scanner) {
        boolean isAdmin = true;
        while (isAdmin) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add Tenant");
            System.out.println("2. Remove Tenant");
            System.out.println("3. View Access Logs");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int adminChoice = scanner.nextInt();

            switch (adminChoice) {
                case 1:
                    handleAddTenant(controller, scanner);
                    break;
                case 2:
                    handleRemoveTenant(controller, scanner);
                    break;
                case 3:
                    handleViewAccessLogs(controller);
                    break;
                case 4:
                    isAdmin = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleAddTenant(DoorLockController controller, Scanner scanner) {
        System.out.print("Enter tenant name: ");
        String name = scanner.next();
        System.out.print("Enter tenant PIN: ");
        String pin = scanner.next();

        try {
            controller.addTenant(pin, name);
            System.out.println("Tenant added successfully.");
        } catch (Exception e) {
            System.out.println("Failed to add tenant: " + e.getMessage());
        }
    }

    private static void handleRemoveTenant(DoorLockController controller, Scanner scanner) {
        System.out.print("Enter tenant name: ");
        String name = scanner.next();

        try {
            controller.removeTenant(name);
            System.out.println("Tenant removed successfully.");
        } catch (Exception e) {
            System.out.println("Failed to remove tenant: " + e.getMessage());
        }
    }

    private static void handleViewAccessLogs(DoorLockController controller) {
        List<AccessLog> accessLogs = controller.getAccessLogs();
        System.out.println("Access Logs:");
        for (AccessLog log : accessLogs) {
            System.out.println(log);
        }
    }

    private static void handleTenantUser(DoorLockController controller, Scanner scanner) {
        boolean isTenant = true;
        while (isTenant) {
            System.out.println("Tenant Menu:");
            System.out.println("1. Enter PIN to open/close the door");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int tenantChoice = scanner.nextInt();

            switch (tenantChoice) {
                case 1:
                    handleEnterPin(controller, scanner);
                    break;
                case 2:
                    isTenant = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleEnterPin(DoorLockController controller, Scanner scanner) {
        System.out.print("Enter PIN: ");
        String pin = scanner.next();

        try {
            DoorStatus status = controller.enterPin(pin);
            System.out.println("Door " + (status == DoorStatus.OPEN ? "closed" : "opened") + " successfully.");
        } catch (TooManyAttemptsException e) {
            System.out.println("Too many attempts. Door locked.");
        } catch (InvalidPinException e) {
            System.out.println("Invalid PIN. Please try again.");
        }
    }
}
