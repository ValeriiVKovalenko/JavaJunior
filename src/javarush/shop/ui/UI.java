package javarush.shop.ui;

import javarush.shop.dao.cashier_dao.CashierDAO;
import javarush.shop.dao.cashier_dao.SQLLiteCashierDAO;
import javarush.shop.dao.product_description_dao.ProductDescriptionDAO;
import javarush.shop.dao.client_dao.ClientDAO;
import javarush.shop.dao.client_dao.SQLLiteClientDAO;
import javarush.shop.dao.product_dao.ProductDAO;
import javarush.shop.dao.product_dao.SQLLiteProductDAO;
import javarush.shop.dao.product_description_dao.SQLLiteProductDescriptionDAO;
import javarush.shop.dao.shop_dao.SQLLiteShopDAO;
import javarush.shop.dao.shop_dao.ShopDAO;
import javarush.shop.dao.warehouse_dao.SQLLiteWarehouseDAO;
import javarush.shop.dao.warehouse_dao.WarehouseDAO;
import javarush.shop.database.DatabaseManager;
import javarush.shop.model.Client;
import javarush.shop.model.Product;
import javarush.shop.model.Warehouse;
import javarush.shop.service.cashier.CashierService;
import javarush.shop.service.cashier.CashierServiceImp;
import javarush.shop.service.client.ClientService;
import javarush.shop.service.client.ClientServiceImpl;
import javarush.shop.service.payment.PaymentService;
import javarush.shop.service.payment.PaymentServiceImpl;
import javarush.shop.service.shop.ShopService;
import javarush.shop.service.shop.ShopServiceImp;


import java.math.BigDecimal;
import java.util.*;

public class UI {
    private final Scanner scanner;

    private ShopService shopService;
    private ClientService clientService;

    public UI() {
        scanner = new Scanner(System.in);
        initializeServices();
    }

    private void initializeServices() {
        ClientDAO clientDAO = new SQLLiteClientDAO(DatabaseManager.getInstance());
        ProductDAO productDAO = new SQLLiteProductDAO(DatabaseManager.getInstance());
        CashierDAO cashierDAO = new SQLLiteCashierDAO(DatabaseManager.getInstance());
        ShopDAO shopDAO = new SQLLiteShopDAO(DatabaseManager.getInstance());
        ProductDescriptionDAO productDescriptionDAO = new SQLLiteProductDescriptionDAO(DatabaseManager.getInstance());
        WarehouseDAO warehouseDAO = new SQLLiteWarehouseDAO(DatabaseManager.getInstance());
        Warehouse warehouse = new Warehouse(productDAO, productDescriptionDAO, warehouseDAO);
        clientService = new ClientServiceImpl(clientDAO);
        PaymentService paymentService = new PaymentServiceImpl();
        CashierService cashierService = new CashierServiceImp(cashierDAO);
        shopService = new ShopServiceImp(warehouse, paymentService, cashierService, clientService, shopDAO);
    }

    public void start() {

        System.out.print("Welcome to the shop.\nPlease enter your name: ");
        String clientName = scanner.nextLine();

        while (isTheNameEnteredCorrectly(clientName)) {
            System.out.print("You entered an invalid name. Try again: ");
            clientName = scanner.nextLine();
        }

        boolean isClientExist = clientService.isClientExist(clientName);

        if (isClientExist) {
            Client client = clientService.getClientByName(clientName);
            System.out.printf("Welcome back, %s!%n", client.getName());
        } else {
            BigDecimal clientBalance = null;
            boolean isValidInput = false;

            while (!isValidInput) {
                System.out.print("Enter your balance: ");

                if (scanner.hasNextBigDecimal()) {
                    clientBalance = scanner.nextBigDecimal();
                    if (isTheBalanceEnteredCorrectly(clientBalance)) {
                        isValidInput = true;
                    }
                } else {
                    System.out.println("You entered an invalid balance. Try again.");
                    scanner.nextLine();
                }
            }

            clientService.saveClient(clientName, clientBalance);
            System.out.println("You has been registered.");
        }

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
                    do {
                        System.out.print("Select product: ");
                        String selectedItem = scanner.next().toLowerCase();
                        boolean inputValidator = false;
                        while (!inputValidator) {
                            boolean isProductExist = shopService.hasProductByName(selectedItem);
                            if (isProductExist) {
                                inputValidator = true;
                            } else {
                                System.out.print("Selected product doesn't exist. Try one more time: ");
                                selectedItem = scanner.next().toLowerCase();
                            }
                        }

                        System.out.printf("Select count of %s: ", selectedItem);
                        int selectedCount = scanner.nextInt();
                        scanner.nextLine();

                        boolean inputValidator2 = false;
                        while (!inputValidator2) {
                            boolean isProductSufficientExist = shopService.hasProductSufficientCount(selectedItem, selectedCount);

                            if (isProductSufficientExist) {
                                inputValidator2 = true;
                            } else {
                                System.out.print("Selected product sufficient doesn't exist. Try one more time: ");
                                selectedCount = scanner.nextInt();
                                scanner.nextLine();
                            }
                        }

                        addItemToBasket(clientName, selectedItem, selectedCount);

                        hasContinueShopping = shouldExitLoop(scanner);
                    } while (hasContinueShopping);
                    break;
                case REMOVE_ITEM_FROM_BASKET:
                    boolean hasContinueRemoving;

                    do {

                        Map<Product, Integer> basket = clientService.getBasket(clientName);
                        if (basket.isEmpty()) {
                            System.out.println("Your basket is empty.");
                            break;
                        }

                        System.out.print("Choose a way to remove: (product/count): ");
                        String chooseWayToRemove = scanner.nextLine();

                        if (chooseWayToRemove.equalsIgnoreCase("product")) {
                            System.out.print("Select product to remove: ");
                            String selectedProductToRemove = scanner.nextLine().toLowerCase();
                            removeItemFromBasket(clientName, selectedProductToRemove);
                        } else if (chooseWayToRemove.equalsIgnoreCase("count")) {
                            System.out.print("Select product to remove: ");
                            String selectedProductToRemove = scanner.nextLine().toLowerCase();


                            System.out.print("Select count to remove: ");
                            int selectedCountToRemove = scanner.nextInt();
                            scanner.nextLine();
                            removeItemFromBasket(clientName, selectedProductToRemove, selectedCountToRemove);
                        }

                        hasContinueRemoving = shouldExitLoop(scanner);
                    } while (hasContinueRemoving);
                    break;
                case SHOW_YOUR_BASKET:
                    displayBasket(clientName);
                    break;
                case CHECKOUT:
                    checkout(clientName);
                    break;
                case RETURN_PRODUCT:
                    System.out.print("Enter what product you want to return: ");
                    String productToReturn = scanner.nextLine().toLowerCase();

                    System.out.print("Enter count: ");
                    int count = scanner.nextInt();
                    scanner.nextLine();

                    returnProduct(clientName, productToReturn, count);
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
        System.out.println("===== Main Menu =====");
        for (MenuCommand command : MenuCommand.values()) {
            System.out.printf("%d. %s%n", command.getNumberOfOperation(), command.getDescription());
        }
        System.out.println("=====================");
    }

    private void displayProductTypes() {
        System.out.println("Available product types:");
        List<String> productTypes = shopService.getWarehouse().getProductTypes();
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

    private void addItemToBasket(String clientName, String selectedItem, Integer selectedCount) {
        Long productId = shopService.getWarehouse().getProductId(selectedItem);
        clientService.addItemToBasket(clientName, productId, selectedCount);
        System.out.printf("%d pcs. %s added to basket.%n", selectedCount, selectedItem);


    }

    private void removeItemFromBasket(String clientName, String selectedItemToRemove) {

        Long productId = shopService.getWarehouse().getProductId(selectedItemToRemove);

        boolean inputValidate = false;
        while (!inputValidate) {
            boolean isSelectedItemInBasketExist = clientService.isProductInBasketExist(clientName, productId);
            if (!isSelectedItemInBasketExist) {
                System.out.printf("%s does not exist in your basket.Try one more time: ", selectedItemToRemove);
                selectedItemToRemove = scanner.nextLine();
            } else {
                clientService.removeItemFromBasket(clientName, productId);
                inputValidate = true;
            }
        }
    }

    private void removeItemFromBasket(String clientName, String selectedItemToRemove, Integer selectedCount) {

        Long productId = shopService.getWarehouse().getProductId(selectedItemToRemove);

        boolean isInputValid = false;

        while (!isInputValid) {

            boolean isSelectedItemInBasketExist = clientService.isProductInBasketExist(clientName, productId);

            if (!isSelectedItemInBasketExist) {
                System.out.printf("%s does not exist in your basket.Try one more time: ", selectedItemToRemove);
                selectedItemToRemove = scanner.nextLine();
            } else {
                boolean isValidCount = true;
                do {

                    boolean isProductSufficientInBasketExist =
                            clientService.isProductSufficientInBasketExist(clientName, productId, selectedCount);
                    if (!isProductSufficientInBasketExist) {
                        System.out.println("You entered the wrong count. Try one more time.");
                        System.out.printf("Select the right count of %s:", selectedItemToRemove);
                        selectedCount = scanner.nextInt();
                        scanner.nextLine();
                    } else {
                        clientService.removeItemFromBasket(clientName, productId, selectedCount);
                        System.out.printf("%d pcs. %s removed from basket.%n", selectedCount, selectedItemToRemove);
                        isValidCount = false;
                        isInputValid = true;
                    }
                } while (isValidCount);
            }
        }
    }

    private void displayBasket(String clientName) {
        Map<Product, Integer> clientBasket = clientService.getBasket(clientName);
        if (clientBasket.isEmpty()) {
            System.out.println("Your basket is empty.");
        }
        for (Map.Entry<Product, Integer> entry : clientBasket.entrySet()) {
            String productName = entry.getKey().getName();
            BigDecimal price = entry.getKey().getPrice();
            Integer count = entry.getValue();
            System.out.printf("%s: %d pcs. -> %.2f₴%n", productName, count, price.multiply(BigDecimal.valueOf(count)));
        }
    }

    public void checkout(String clientName) {
        Map<Product, Integer> clientBasket = clientService.getBasket(clientName);
        for (Map.Entry<Product, Integer> entry : clientBasket.entrySet()) {

            Product product = entry.getKey();
            Integer productCount = entry.getValue();
            String productType = entry.getKey().getProductDescription().getType();
            shopService.transferItemToClient(clientName, product, productType, productCount);
        }
    }

    public void returnProduct(String clientName, String productToReturn, int count) {
        shopService.returnProductFromClient(clientName, productToReturn, count);
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

            if (chosenAnswer.equalsIgnoreCase("no")) {
                exitLoop = false;
                isValidInput = true;
            } else if (chosenAnswer.equalsIgnoreCase("yes")) {
                isValidInput = true;

            } else {
                System.out.println("You entered wrong answer. Try one more time.");
            }
        }
        return exitLoop;
    }

    private boolean isTheNameEnteredCorrectly(String name) {
        return name.isBlank() || name.isEmpty();
    }

    private boolean isTheBalanceEnteredCorrectly(BigDecimal balance) {
       return balance.compareTo(BigDecimal.ZERO) >= 0;
    }
}