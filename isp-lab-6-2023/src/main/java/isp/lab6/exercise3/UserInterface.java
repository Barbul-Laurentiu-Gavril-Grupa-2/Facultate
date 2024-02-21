package isp.lab6.exercise3;

import java.util.List;
import java.util.Scanner;

class UserInterface {
    private LoginSystem loginSystem;
    private OnlineStore store;
    private Scanner scanner;

    public UserInterface(LoginSystem loginSystem, OnlineStore store) {
        this.loginSystem = loginSystem;
        this.store = store;
        this.scanner = new Scanner(System.in);
    }

    public void loadInterface() {
        int choice = 0;

        while (choice != 6) {
            System.out.println("Online Store Menu");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Logout");
            System.out.println("4. Add to Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
            } catch (Exception e) {
                System.out.println("Invalid choice. Please enter a valid option.");
                scanner.nextLine(); // Consume the entire invalid line
                continue;
            }

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    logoutUser();
                    break;
                case 4:
                    addToCart();
                    break;
                case 5:
                    checkout();
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        scanner.close();
    }

    private void registerUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        loginSystem.register(username, password);
        System.out.println("User registered successfully.");
    }

    private void loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        boolean success = loginSystem.login(username, password);
        if (success) {
            store.addSession(username);
            System.out.println("User logged in successfully.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private void logoutUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        boolean success = loginSystem.logout(username);
        if (success) {
            store.removeSession(username);
            System.out.println("User logged out successfully.");
        } else {
            System.out.println("Invalid username.");
        }
    }

    private void addToCart() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Product product = store.getProductByName(productName);
        if (product != null) {
            double subtotal = product.getPrice() * quantity;
            store.addToCart(username, String.valueOf(product), quantity);
            System.out.println("Product added to cart.");

            System.out.println("Product: " + product.getName());
            System.out.println("Quantity: " + quantity);
            System.out.println("Subtotal: $" + subtotal);
        } else {
            System.out.println("Product not found.");
        }
    }
    private void checkout() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        String receipt = store.checkout(username);
        System.out.println(receipt);
    }
}
