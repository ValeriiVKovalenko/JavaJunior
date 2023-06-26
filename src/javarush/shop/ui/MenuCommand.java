package javarush.shop.ui;

public enum MenuCommand {
    SHOW_PRODUCTS_TYPE(1, "Show product types"),
    SHOW_PRODUCTS_BY_TYPE(2,"Show products by type"),
    ADD_ITEM_TO_BASKET(3, "Add item to basket"),
    REMOVE_ITEM_FROM_BASKET(4, "Remove item from basket"),
    SHOW_YOUR_BASKET(5, "Show your basket"),
    CHECKOUT(6, "Checkout"),
    RETURN_PRODUCT(7, "Return product"),
    EXIT(8, "Exit");

    private final int label;
    private final String description;

    MenuCommand(int numberOfOperation, String description) {
        this.label = numberOfOperation;
        this.description = description;
    }

    public int getNumberOfOperation() {
        return label;
    }

    public String getDescription() {
        return description;
    }
}
