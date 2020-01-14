package dao.impl;

import dao.Dao;
import model.Basket;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class BasketDao implements Dao<Basket> {

    private List<Product> basket = new ArrayList<>();

    @Override
    public Basket get(int id) {
        return null;
    }

    @Override
    public Basket get(String name) {
        return null;
    }

    public List<Product> showContentOfBasket() {
        return basket;
    }

    @Override
    public List<Basket> getAll() {
        return null;
    }

    public void addProductToTheBasket(Product product) {
        basket.add(product);
    }

    @Override
    public void save(Basket basket) {

    }

    @Override
    public void update(Basket basket, String[] params) {

    }

    @Override
    public void delete(Basket basket) {

    }
}
