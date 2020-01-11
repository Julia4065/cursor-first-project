package model;

import java.math.BigDecimal;

public class Product {
    private String name;
    private String description;
    private BigDecimal price;
    private boolean isAvailable;
    private ProductGroup group;

    public Product(String name, String description, BigDecimal price, boolean isAvailable, ProductGroup group) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                ", group='" + group + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }


    public enum ProductGroup {
        TABLETS, LAPTOPS, SMARTPHONES, TV, APPLIANCES
    }

}
