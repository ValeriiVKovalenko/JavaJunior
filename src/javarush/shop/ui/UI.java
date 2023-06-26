package javarush.shop.ui;

import javarush.shop.model.Cashier;
import javarush.shop.model.Client;
import javarush.shop.model.Product;
import javarush.shop.model.Shop;
import javarush.shop.service.client.ClientService;
import javarush.shop.service.client.ClientServiceImpl;
import javarush.shop.service.product.ProductService;
import javarush.shop.service.product.ProductServiceImpl;
import javarush.shop.service.shop.ShopService;
import javarush.shop.service.shop.ShopServiceImp;

import java.util.*;

public class UI {
    private final Scanner scanner;
    private Client client;

    private ShopService shopService;
    private ClientService clientService;
    private ProductService productService;

    public UI() {
        scanner = new Scanner(System.in);
        clientService = new ClientServiceImpl();
        productService = new ProductServiceImpl();
    }

    public void setShopService(ShopService shopService) {
        this.shopService = shopService;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void start(Client client) {
        setClient(client);
        clientService.setClient(client);

        displayMenu();
        boolean isEndOfShopping = false;

        while (!isEndOfShopping) {

            System.out.print("Select command: ");
            int currentOption = scanner.nextInt();
            scanner.nextLine();

            MenuCommand selectedCommand = getMenuCommandByLabel(currentOption);
            if (selectedCommand == null) {
                System.out.println("Entered the wrong command. Try again");
                continue;
            }

            switch (selectedCommand) {
                case SHOW_PRODUCTS_TYPE:
                    displayProductTypes();
                    break;
                case SHOW_PRODUCTS_BY_TYPE:
                    displayProductsByType();
                    break;
                case ADD_ITEM_TO_BASKET:
                    boolean hasContinueShopping;
                    Map<Product, Integer> products = shopService.getProducts();
                    do {

                        System.out.print("Select product: ");
                        String selectedItem = scanner.next();
//                        shopService.hasProductName(selectedItem);

                        System.out.printf("Select count of %s: ", selectedItem);
                        int selectedCount = scanner.nextInt();
                        scanner.nextLine();

                        addItemToBasket(selectedItem, selectedCount, products);

                        hasContinueShopping = shouldExitLoop(scanner);
                    } while (hasContinueShopping);
                    break;
                case REMOVE_ITEM_FROM_BASKET:
                    boolean hasContinueRemoving;

                    Map<Product, Integer> basket = clientService.getBasket();
                    do {

                        System.out.print("Choose a way to remove: (product/count): ");
                        String chooseWayToRemove = scanner.nextLine();

                        if (chooseWayToRemove.equals("product")) {
                            System.out.print("Select product to remove: ");
                            String selectedProductToRemove = scanner.nextLine();
                            removeItemFromBasket(selectedProductToRemove, basket);
                        } else if (chooseWayToRemove.equals("count")) {
                            System.out.print("Select product to remove: ");
                            String selectedProductToRemove = scanner.nextLine();

                            System.out.print("Select count to remove: ");
                            int selectedCountToRemove = scanner.nextInt();
                            scanner.nextLine();

                            removeItemFromBasket(selectedProductToRemove, selectedCountToRemove, basket);
                        }

                        hasContinueRemoving = shouldExitLoop(scanner);
                    } while (hasContinueRemoving);
                    break;
                case SHOW_YOUR_BASKET:
                    displayBasket();
                    break;
                case CHECKOUT:
                    checkout();
                    break;
                case RETURN_PRODUCT:
                    System.out.print("Enter what product you want to return: ");
                    String productToReturn = scanner.nextLine();

                    System.out.print("Enter count: ");
                    int count = scanner.nextInt();
                    scanner.nextLine();

                    returnProduct(productToReturn, count);
                    break;
                case EXIT:
                    isEndOfShopping = true;
                    break;
                default:
                    System.out.println("Entered the wrong command. Try again");
            }
        }
        System.out.println("Goodbye!");
    }

    private void displayMenu() {
        System.out.println("Welcome to Shop!");
        System.out.println("===== Main Menu =====");
        for (MenuCommand command : MenuCommand.values()) {
            System.out.printf("%d. %s%n", command.getNumberOfOperation(), command.getDescription());
        }
        System.out.println("=====================");
    }

    private void displayProductTypes() {
        System.out.println("Available product types:");
        Set<String> productTypes = shopService.getWarehouse().getProductTypes();
        for (String productType : productTypes) {
            System.out.println(productType);
        }
    }

    private void displayProductsByType() {
        Map<String, List<Product>> productsByType = shopService.getProductsByType();

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

    private void addItemToBasket(String selectedItem, Integer selectedCount, Map<Product, Integer> products) {

        boolean isSelectedItemExits = isSelectedItemExits(products.keySet(), selectedItem);

        if (!isSelectedItemExits) {
            System.out.printf("%s does not exist.", selectedItem);
        }

        Map.Entry<Product, Integer> productEntry = shopService.getProductEntryByName(selectedItem);

        boolean isValidCount = true;
        do {

            if (selectedCount > productEntry.getValue() || selectedCount < 1) {
                System.out.println("You entered wrong count. Try one more time.");
                System.out.printf("Select count of %s:", selectedItem);
                selectedCount = scanner.nextInt();
                scanner.nextLine();
            } else {
                clientService.addItemToBasket(productEntry.getKey(), selectedCount);
                System.out.printf("%d pcs. %s added to basket.%n", selectedCount, productEntry.getKey().getName());
                shopService.getWarehouse().removeProduct(productEntry.getKey(), selectedCount);
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

    private void removeItemFromBasket(String selectedItemToRemove, Map<Product, Integer> basket) {

        boolean isSelectedItemExits = isSelectedItemExits(basket.keySet(), selectedItemToRemove);

        if (!isSelectedItemExits) {
            System.out.printf("%s does not exist.%n", selectedItemToRemove);
        }

        Map<Product, Integer> currentBasket = clientService.getBasket();

        for (Map.Entry<Product, Integer> entry : currentBasket.entrySet()) {

            String productName = entry.getKey().getName();
            Product product = entry.getKey();
            Integer count = entry.getValue();

            if (selectedItemToRemove.equalsIgnoreCase(productName)) {
                clientService.removeItemFromBasket(product);
                System.out.printf("%s removed from basket.%n", productName);
                shopService.getWarehouse().addProduct(product, count);
            }
        }
    }

    private void removeItemFromBasket(String selectedItemToRemove, Integer selectedCount,
                                      Map<Product, Integer> basket) {

        boolean isSelectedItemExits = isSelectedItemExits(basket.keySet(), selectedItemToRemove);

        if (!isSelectedItemExits) {
            System.out.printf("%s does not exist.%n", selectedItemToRemove);
            return;
        }

        Map.Entry<Product, Integer> productEntry = shopService.getProductEntryByName(selectedItemToRemove, basket);

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
                clientService.removeItemFromBasket(product, selectedCount);
                System.out.printf("%d pcs. %s left in the basket.%n", basketCount - selectedCount, selectedItemToRemove);
                shopService.getWarehouse().addProduct(product, selectedCount);
                isValidCount = false;
            }
        } while (isValidCount);
    }

    private void displayBasket() {
        Map<Product, Integer> basket = clientService.getBasket();
        if (basket.isEmpty()) {
            System.out.println("Your basket is empty.");
        }
        for (Map.Entry<Product, Integer> entry : basket.entrySet()) {
            String productName = entry.getKey().getName();
            Double price = entry.getKey().getPrice();
            Integer count = entry.getValue();
            System.out.printf("%s: %d pcs. -> %.2f₴%n", productName, count, price * count);
        }
    }

    public void checkout() {
        Map<Product, Integer> basket = clientService.getBasket();

        for (Map.Entry<Product, Integer> entry : basket.entrySet()) {

            Product product = entry.getKey();
            Integer count = entry.getValue();
            String productType = entry.getKey().getProductDescription().getType();

            double totalPrice = product.getPrice() * count;
            Cashier cashierByProductType = shopService.getCashierByProductType(productType);
            if (clientService.getBalance() >= totalPrice) {
                shopService.transferItemToClient(cashierByProductType, product, count);

                clientService.setBalance(clientService.getBalance() - totalPrice);
                shopService.setBank(shopService.getBank() + totalPrice);

                basket.clear();
                System.out.println("The operation was completed successfully.");
            } else {
                System.out.println("Insufficient funds in the account.");
            }
        }
    }

    public void returnProduct(String productToReturn, int count) {
        Map<Product, Integer> productMap = shopService.getWarehouse().getProductMap();
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {

            Product product = entry.getKey();
            String productName = entry.getKey().getName();
            String productType = entry.getKey().getProductDescription().getType();

            double totalPrice = productService.getPrice() * count;
            Cashier cashierByProductType = shopService.getCashierByProductType(productType);

            if (productToReturn.equalsIgnoreCase(productName)) {
                shopService.returnProductFromClient(cashierByProductType, product, count);
                clientService.setBalance(client.getBalance() + totalPrice);
                shopService.setBank(shopService.getBank() - totalPrice);

                System.out.printf("%d pcs. %s was successfully returned%n", count, productName);
            }
        }
    }

    private MenuCommand getMenuCommandByLabel(int label) {
        for (MenuCommand command : MenuCommand.values()) {
            if (command.getNumberOfOperation() == label) {
                return command;
            }
        }
        return null;
    }

    private boolean shouldExitLoop(Scanner scanner) {
        boolean exitLoop = true;
        boolean isValidInput = false;

        while (!isValidInput) {

            System.out.print("Would you like to continue? (yes/no): ");
            String chosenAnswer = scanner.nextLine().toLowerCase();

            if (chosenAnswer.equals("no")) {
                exitLoop = false;
                isValidInput = true;
            } else if (chosenAnswer.equals("yes")) {
                isValidInput = true;

            } else {
                System.out.println("You entered wrong answer. Try one more time.");
            }
        }
        return exitLoop;
    }
}