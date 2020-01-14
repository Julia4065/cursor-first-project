package service;

import dao.impl.BasketDao;
import model.Product;

import java.util.List;

public class BasketService {

    BasketDao basketDao = new BasketDao();

    public void addProductToTheBasket(Product productToBeAddedToBasket) {
        basketDao.addProductToTheBasket(productToBeAddedToBasket);
    }

    public void showContentOfBasket() {
        List<Product> productsInBasket = basketDao.showContentOfBasket();
        System.out.println("Products in basket: ");
        productsInBasket.forEach(System.out::println);
    }
}
