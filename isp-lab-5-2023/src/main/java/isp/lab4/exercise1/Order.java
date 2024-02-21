package isp.lab4.exercise1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private LocalDateTime date;
    private Double totalPrice;
    private List<Product> products = new ArrayList<>();

    public Order(String orderId, LocalDateTime date, Double totalPrice) {
        this.orderId = orderId;
        this.date = date;
        this.totalPrice = totalPrice;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    //Getters and setters omitted for brevity
}

