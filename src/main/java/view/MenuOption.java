package view;

public enum MenuOption {

    LIST_OF_PRODUCTS(1, "Show list of products"),
    SEARCH_PRODUCT(2, "Search product"),
    ADD_PRODUCT_TO_THE_BASKET(3, "Add product to the basket"),
    CHECKOUT_AN_ORDER(4, "Сheckout an order"),
    SHOW_BASKET(5, "Show basket"),
    SEND_MESSAGE_TO_ADMIN(6, "Send message to admin"),

    EXIT(0, "To exit");

    private final int optionNumber;
    private final String optionDescription;

    MenuOption(int optionNumber, String optionDescription) {
        this.optionNumber = optionNumber;
        this.optionDescription = optionDescription;
    }

    public int getOptionNumber() {
        return optionNumber;
    }

    public String getOptionDescription() {
        return optionDescription;
    }

    @Override
    public String toString() {
        return optionNumber +
                ". " + optionDescription;
    }
}
