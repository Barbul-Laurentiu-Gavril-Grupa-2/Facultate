package isp.lab3.exercise6;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class VendingMachine {
    private static VendingMachine instance = null;
    private static final int MAX_CREDIT = 10;
    private int credit;
    private String[] products;

    private VendingMachine() {
        this.credit = 0;
        this.products = new String[]{"Cola", "Chips", "Candy"};
    }

    public static VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    public void displayProducts() {
        System.out.println("Available products:");
        for (int i = 0; i < products.length; i++) {
            System.out.println(i + ": " + products[i]);
        }
    }

    public void insertCoin(int value) {
        if (value > 0 && credit < MAX_CREDIT) {
            credit += value;
            System.out.println("Credit increased by " + value + ". Current credit: " + credit);
        } else if (value > 0 && credit >= MAX_CREDIT) {
            System.out.println("Maximum credit reached.");
        } else {
            System.out.println("Invalid coin value.");
        }
    }

    public String selectProduct(int id) {
        if (id < 0 || id >= products.length) {
            return "Invalid selection.";
        } else if (credit < 1) {
            return "Insufficient credit.";
        } else {
            credit--;
            return "Dispensing " + products[id] + ".";
        }
    }

    public void displayCredit() {
        System.out.println("Current credit: " + credit);
    }

    public void userMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Select an option:");
            System.out.println("1. Display products");
            System.out.println("2. Insert coin");
            System.out.println("3. Select product");
            System.out.println("4. Display credit");
            System.out.println("5. Quit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    System.out.println("Enter coin value:");
                    int value = scanner.nextInt();
                    insertCoin(value);
                    break;
                case 3:
                    System.out.println("Enter product selection:");
                    int id = scanner.nextInt();
                    System.out.println(selectProduct(id));
                    break;
                case 4:
                    displayCredit();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
