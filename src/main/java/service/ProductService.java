package service;

import dao.impl.ProductDao;
import model.Product;

import java.util.List;
import java.util.Scanner;

public class ProductService {

    ProductDao productDao = new ProductDao();

    public void showAllProducts() {
        List<Product> products = productDao.getAll();
        System.out.println("List of all products: ");
        products.forEach(System.out::println);
    }

    public void searchProductByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String productName = scanner.next();
        Product product = productDao.get(productName);
        System.out.println("Product with name " + productName + ": ");
        System.out.println(product);
    }

}
