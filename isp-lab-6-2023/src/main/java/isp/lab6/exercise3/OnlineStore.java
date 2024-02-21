package isp.lab6.exercise3;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class OnlineStore {
    private List<Product> products;
    private Map<String, ActiveSession> sessions;

    public OnlineStore() {
        this.products = new ArrayList<>(); // Initialize the products list
        // Add sample products
        products.add(new Product("iPhone", 1000));
        products.add(new Product("Samsung Galaxy", 800));
        products.add(new Product("Google Pixel", 900));

        this.sessions = new HashMap<>();
    }
    public Product getProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
    public List<Product> getProductsSorted(Comparator<Product> sortCriteria) {
        List<Product> sortedProducts = new ArrayList<>(products);
        sortedProducts.sort(sortCriteria);
        return sortedProducts;
    }

    protected void addSession(String username) {
        if (sessions == null) {
            sessions = new HashMap<>();
        }
        sessions.put(username, new ActiveSession(username));
    }

    protected void removeSession(String username) {
        if (sessions != null) {
            sessions.remove(username);
        }
    }

    public void addToCart(String username, String product, int quantity) {
        ActiveSession session = sessions.get(username);
        if (session != null) {
            session.addToCart(product, quantity);
        }
    }

    public String checkout(String username) {
        ActiveSession session = sessions.get(username);
        if (session != null) {
            return session.checkout();
        }
        return "No active session found for user: " + username;
    }
}

