package javarush.shop;

import java.util.*;

public class UI {
    private Shop shop;
    private Client client;
    private MenuCommand menuCommand;

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void displayMenu() {
        System.out.println("===== Main Menu =====");
        for (MenuCommand command : MenuCommand.values()) {
            System.out.printf("%d. %s%n", command.getLabel(), command.getDescription());
        }
        System.out.println("=====================");
    }

    public void displayProductTypes() {
        System.out.println("Available product types:");
        Set<String> productTypes = shop.getWarehouse().getProductTypes();
        for (String productType : productTypes) {
            System.out.println(productType);
        }
    }

    public void displayProductsByType() {
        Map<String, List<Product>> productsByType = shop.getProductsByType();

        for (Map.Entry<String, List<Product>> entry : productsByType.entrySet()) {
            String productType = entry.getKey();
            List<Product> products = entry.getValue();

            System.out.println("Product type: " + productType);

            for (Product product : products) {
                System.out.printf("-> %s: %.2f₴%n", product.getName(), product.getPrice());
            }
            System.out.println();
        }
    }

    public void addItemToBasket(String selectedItem, Integer selectedCount, Map<Product, Integer> products, Scanner scanner) {

        boolean isSelectedItemExits = isSelectedItemExits(products.keySet(), selectedItem);

        if (!isSelectedItemExits) {
            System.out.printf("%s does not exist.", selectedItem);
        }

        Map.Entry<Product, Integer> productEntry = shop.getProductEntryByName(selectedItem);

        boolean isValidCount = true;
        do {

            if (selectedCount > productEntry.getValue() || selectedCount < 1) {
                System.out.println("You entered wrong count. Try one more time.");
                System.out.printf("Select count of %s:", selectedItem);
                selectedCount = scanner.nextInt();
                scanner.nextLine();
            } else {
                client.addItemToBasket(productEntry.getKey(), selectedCount);
                System.out.printf("%d pcs. %s added to basket.%n", selectedCount, productEntry.getKey().getName());
                shop.getWarehouse().removeProduct(productEntry.getKey(), selectedCount);
                isValidCount = false;
            }
        } while (isValidCount);
    }

    private boolean isSelectedItemExits(Set<Product> products, String selectedItem) {

        if (selectedItem == null || selectedItem.isBlank()) {
            return false;
        }

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(selectedItem)) {
                return true;
            }
        }
        return false;
    }

    public void removeItemFromBasket(String selectedItemToRemove, Map<Product, Integer> basket) {

        boolean isSelectedItemExits = isSelectedItemExits(basket.keySet(), selectedItemToRemove);

        if (!isSelectedItemExits) {
            System.out.printf("%s does not exist.%n", selectedItemToRemove);
        }

        Map<Product, Integer> currentBasket = client.getBasket();

        for (Map.Entry<Product, Integer> entry : currentBasket.entrySet()) {

            String productName = entry.getKey().getName();
            Product product = entry.getKey();
            Integer count = entry.getValue();

            if (selectedItemToRemove.equalsIgnoreCase(productName)) {
                client.removeItemFromBasket(product);
                System.out.printf("%s removed from basket.%n", productName);
                shop.getWarehouse().addProduct(product, count);
            }
        }
    }

    public void removeItemFromBasket(String selectedItemToRemove, Integer selectedCount, Map<Product, Integer> basket,
                                     Scanner scanner) {

        boolean isSelectedItemExits = isSelectedItemExits(basket.keySet(), selectedItemToRemove);

        if (!isSelectedItemExits) {
            System.out.printf("%s does not exist.%n", selectedItemToRemove);
            return;
        }

        Map.Entry<Product, Integer> productEntry = shop.getProductEntryByName(selectedItemToRemove, basket);

        if (productEntry == null) {
            System.out.printf("%s not found in basket.%n", selectedItemToRemove);
            return;
        }

        Product product = productEntry.getKey();
        Integer basketCount = productEntry.getValue();

        boolean isValidCount = true;
        do {

            if (selectedCount > basketCount || selectedCount < 1) {
                System.out.println("You entered wrong count. Try one more time.");
                System.out.printf("Select right count of %s:", selectedItemToRemove);
                selectedCount = scanner.nextInt();
                scanner.nextLine();
            } else {
                client.removeItemFromBasket(product, selectedCount);
                System.out.printf("%d pcs. %s left in the basket.%n", basketCount - selectedCount, selectedItemToRemove);
                shop.getWarehouse().addProduct(product, selectedCount);
                isValidCount = false;
            }
        } while (isValidCount);
    }

    public void displayBasket() {
        Map<Product, Integer> basket = client.getBasket();
        if (basket.isEmpty()) {
            System.out.println("Your basket is empty.");
        }
        for (Map.Entry<Product, Integer> entry : basket.entrySet()) {
            Product product = entry.getKey();
            String productName = entry.getKey().getName();
            Double price = entry.getKey().getPrice();
            Integer count = entry.getValue();
            System.out.printf("%s: %d pcs. -> %.2f₴%n", productName, count, price * count);
        }
    }

    public void checkout() {
        Map<Product, Integer> basket = client.getBasket();

        for (Map.Entry<Product, Integer> entry : basket.entrySet()) {

            Product product = entry.getKey();
            Integer count = entry.getValue();
            String productType = entry.getKey().getProductDescription().getType();

            double totalPrice = product.getPrice() * count;
            Cashier cashierByProductType = shop.getCashierByProductType(productType);
            if (client.getBalance() > totalPrice) {
                shop.transferItemToClient(cashierByProductType, product, count);

                client.setBalance(client.getBalance() - totalPrice);
                shop.setBank(shop.getBank() + totalPrice);

                System.out.println("The operation was completed successfully.");
                System.out.println("Your balance: " + client.getBalance() + '₴');
                System.out.println("Shop balance: " + shop.getBank() + '₴');
            } else {
                System.out.println("Insufficient funds in the account.");
            }
        }
        basket.clear();
    }

    public void returnProduct(String productToReturn, int count) {
        Map<Product, Integer> productMap = shop.getWarehouse().getProductMap();
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {

            Product product = entry.getKey();
            String productName = entry.getKey().getName();
            String productType = entry.getKey().getProductDescription().getType();

            double totalPrice = product.getPrice() * count;
            Cashier cashierByProductType = shop.getCashierByProductType(productType);

            if (productToReturn.equalsIgnoreCase(productName)) {
                shop.returnProductFromClient(cashierByProductType, product, count);
                client.setBalance(client.getBalance() + totalPrice);
                shop.setBank(shop.getBank() - totalPrice);

                System.out.printf("%d pcs. %s was successfully returned%n", count, productName);
                System.out.println("Your balance: " + client.getBalance() + '₴');
                System.out.println("Shop balance: " + shop.getBank() + '₴');
            }
        }
    }

    public MenuCommand getMenuCommandByLabel(int label) {
        for (MenuCommand command : MenuCommand.values()) {
            if (command.getLabel() == label) {
                return command;
            }
        }
        return null;
    }
}
