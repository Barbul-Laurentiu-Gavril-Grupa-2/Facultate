package isp.lab6.exercise3;

import java.util.Objects;

class Product {
    private String name;
    private double  price;

    public Product(String name, double  price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double  getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double  price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product other = (Product) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
