package isp.lab3.exercise5;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
    private int coins;
    private Map<Integer, Product> products;
    private final String adminPassword = "8643"; // Parola pentru modul administrator

    public VendingMachine() {
        coins = 0;
        products = new HashMap<>();
        addProduct(1, "Coke", 1.5, 10);
        addProduct(2, "Chips", 1.0, 20);
        addProduct(3, "Candy", 0.75, 15);
    }

    public void addProduct(int id, String name, double price, int quantity) {
        Product product = new Product(name, price, quantity);
        products.put(id, product);
    }

    public void updateProduct(int id) {
        Product product = products.get(id);
        product.setCantitate(product.getCantitate() - 1);
        products.replace(id, product);
    }
    public String displayProducts() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            int id = entry.getKey();
            Product product = entry.getValue();
            sb.append(id).append(". ").append(product.getNume()).append(" Cantitate: ").append(product.getCantitate()).append(" Pret: ").append(product.getPret()).append("\n");
        }
        return sb.toString();
    }

    public void insertCoins(int coins) {
        this.coins += coins;
    }

    public String selectProduct(int id) {
        if (products.containsKey(id)) {
            Product product = products.get(id);
            if (product.getCantitate() > 0) {
                return "Ati ales produsul: " + product.getNume();
            } else {
                return "Produsul " + product.getNume() + " nu mai este disponibil.";
            }
        } else if (id != -1) {
            return "Id introdus gresit!";
        }
        return "0";
    }
    public String getProductName(int id)
    {
        return products.get(id).getNume();
    }
    public void displayCredits() {
        System.out.println("Total coins: " + coins);
    }

    public int getCoins() {
        return coins;
    }

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        Scanner scanner = new Scanner(System.in);
        int selectedOption = 0;
        boolean isAdmin = false;

        while (selectedOption != -1) {
            System.out.println(vendingMachine.displayProducts());
            System.out.println("Options: 1. Insert coins 2. Select product");
            System.out.println("Enter your option: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    System.out.println("Enter coins to insert: ");
                    int insertedCoins = Integer.parseInt(scanner.nextLine());
                    vendingMachine.insertCoins(insertedCoins);
                    System.out.println("You have inserted: " + insertedCoins + " coins. Total: " + vendingMachine.getCoins());
                    break;
                case 2:
                    vendingMachine.displayProducts();

                    do {
                        System.out.println("Enter the product ID: ");
                        int productId = Integer.parseInt(scanner.nextLine());
                        String result = vendingMachine.selectProduct(productId);
                        if (result.equals("Id introdus gresit!")) {
                            System.out.println(result);
                        } else if (result.equals("0") && productId != -1) {
                            System.out.println("To exit, enter -1");
                        } else {
                            System.out.println(result);
                            if (!result.contains("nu mai este disponibil")) {
                                vendingMachine.updateProduct(productId);
                            }
                            selectedOption = -1;
                            break;
                        }
                    } while (vendingMachine.selectProduct(selectedOption).equals("0") && selectedOption != -1);
                    break;
                case 8643:
                    System.out.println("Enter secret code: ");
                    String secretCode = scanner.nextLine();
                    if (secretCode.equals(vendingMachine.adminPassword)) {
                        isAdmin = true;
                        System.out.println("Administrator mode. Enter product details:");
                        System.out.print("ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Price: ");
                        double price = Double.parseDouble(scanner.nextLine());
                        System.out.print("Quantity: ");
                        int quantity = Integer.parseInt(scanner.nextLine());
                        vendingMachine.addProduct(id, name, price, quantity);
                        System.out.println("Product added successfully!");
                    } else {
                        System.out.println("Invalid secret code!");
                    }
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
}
