package isp.lab6.exercise3;

import java.util.HashMap;
import java.util.Map;

class ActiveSession {
    private String username;
    private Map<String, Integer> shoppingCart;

    public ActiveSession(String username) {
        this.username = username;
        this.shoppingCart = new HashMap<>();
    }

    public void addToCart(String product, int quantity) {
        shoppingCart.put(product, shoppingCart.getOrDefault(product, 0) + quantity);
    }

    public String checkout() {
        StringBuilder receipt = new StringBuilder("Checkout for user: " + username + "\n");
        double total = 0.0;
        for (Map.Entry<String, Integer> entry : shoppingCart.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            double price = getProductPrice(product);
            double subtotal = price * quantity;
            total += subtotal;
            receipt.append(product).append(" (Quantity: ").append(quantity).append(") - Subtotal: $")
                    .append(subtotal).append("\n");
        }
        receipt.append("Total: $").append(total);
        shoppingCart.clear();
        return receipt.toString();
    }

    private double getProductPrice(String product) {
        // Retrieve product price from the store's product list or database
        // Replace this with your own implementation
        if (product.equals("Product A")) {
            return 10.0;
        } else if (product.equals("Product B")) {
            return 15.0;
        } else if (product.equals("Product C")) {
            return 20.0;
        }
        return 0.0; // Default price if product not found
    }
}
