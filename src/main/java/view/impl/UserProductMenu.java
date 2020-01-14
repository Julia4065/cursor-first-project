package view.impl;

import model.Product;
import service.BasketService;
import service.MessageService;
import service.ProductService;
import view.MenuOption;

import java.math.BigDecimal;
import java.util.Scanner;

public class UserProductMenu {

    Scanner scanner = new Scanner(System.in);

    public void operateWithProductMenu() {

        ProductService productService = new ProductService();
        BasketService basketService = new BasketService();
        MessageService messageService = new MessageService();
        int selectedOption;

        do {
            selectedOption = selectedOptionFromProductMenu();

            switch (selectedOption) {
                case 1:
                    productService.showAllProducts();
                    break;
                case 2:
                    productService.searchProductByName();
                    break;
                case 3:
                    basketService.addProductToTheBasket(enterProduct());
                    break;
                case 4:
//                basketService.checkoutAnOrder();
                    break;
                case 5:
                    basketService.showContentOfBasket();
                    break;
                case 6:
                    System.out.println("Enter message to admin: ");
                    String messageToAdmin = scanner.next();
                    messageService.sendMessage(1, messageToAdmin);
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        }

        while (selectedOption != 0);

    }

    public int selectedOptionFromProductMenu() {
        System.out.println("User Product menu:");
        System.out.println(MenuOption.LIST_OF_PRODUCTS);
        System.out.println(MenuOption.SEARCH_PRODUCT);
        System.out.println(MenuOption.ADD_PRODUCT_TO_THE_BASKET);
        System.out.println(MenuOption.CHECKOUT_AN_ORDER);
        System.out.println(MenuOption.SHOW_BASKET);
        System.out.println(MenuOption.SEND_MESSAGE_TO_ADMIN);
        System.out.println(MenuOption.EXIT);

        return scanner.nextInt();
    }

    private Product enterProduct() {
        System.out.println("Enter product name: ");
        String nameOfProduct = scanner.next();
        System.out.println("Enter product description: ");
        String descriptionOfProduct = scanner.next();
        System.out.println("Enter price: ");
        BigDecimal priceOfProduct = scanner.nextBigDecimal();
        System.out.println("Is product available: ");
        boolean isProductAvailable = Boolean.valueOf(scanner.next());
        System.out.println("Enter product group: ");
        Product.ProductGroup groupOfProduct = Product.ProductGroup.valueOf(scanner.next());
        return new Product(nameOfProduct, descriptionOfProduct, priceOfProduct, isProductAvailable, groupOfProduct);
    }
}
