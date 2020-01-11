package dao.impl;

import dao.Dao;
import model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDao implements Dao<Product> {

    private List<Product> listOfProducts = new ArrayList<>(List.of(
            new Product("Smartphone Xiaomi", "Xiaomi Note 8", new BigDecimal(4500), true, Product.ProductGroup.SMARTPHONES),
            new Product("Iron", "Smart", new BigDecimal(1200), true, Product.ProductGroup.APPLIANCES),
            new Product("TV", "Samsung 3400", new BigDecimal(7000), true, Product.ProductGroup.TV)));

    @Override
    public Product get(int id) {
        return null;
    }

    @Override
    public Product get(String name) {
        return listOfProducts.stream()
                .filter(product -> product.getName().equals(name))
                .collect(Collectors.toList())
                .get(0);
    }

    @Override
    public List<Product> getAll() {
        return listOfProducts;
    }

    @Override
    public void save(Product product) {
        listOfProducts.add(product);
    }

    @Override
    public void update(Product product, String[] params) {

    }

    @Override
    public void delete(Product product) {

    }


}
