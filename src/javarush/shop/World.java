package javarush.shop;

import java.util.*;

public class World {
    private final List<Client> clientList = new ArrayList<>();
    private final Shop shop = new Shop();
    UI ui = new UI();

    public static void main(String[] args) {
        World world = new World();
        world.initialize();
        Client client = world.clientList.get(0);
        world.start(client);

    }


    public void initialize() {

        clientList.add(new Client("Mirana", 5000));
        clientList.add(new Client("Lion", 10_000));
        clientList.add(new Client("Dazzle", 50_000));

        List<Cashier> cashiers = shop.getCashiers();
        Cashier lina = new Cashier("Lina", 10);
        Cashier enigma = new Cashier("Enigma", 5);
        Cashier jakiro = new Cashier("Jakiro", 1);

        Set<String> productTypesLina = lina.getProductTypes();
        Set<String> productTypesEnigma = enigma.getProductTypes();
        Set<String> productTypesJakiro = jakiro.getProductTypes();

        Collections.addAll(productTypesLina, "Vegetables", "Fruits");
        Collections.addAll(productTypesEnigma, "Cookies", "Cakes", "Buns");
        Collections.addAll(productTypesJakiro, "Alcohol", "Tobacco", "Drinks");
        Collections.addAll(cashiers, lina, enigma);

        Warehouse warehouse = shop.getWarehouse();
        ProductDescription fruits = new ProductDescription("Fruits");
        ProductDescription alcohol = new ProductDescription("Alcohol");
        ProductDescription cakes = new ProductDescription("Cakes");
        ProductDescription vegetables = new ProductDescription("Vegetables");
        ProductDescription drinks = new ProductDescription("Drinks");

        Product prosecco = new Product("Massotina Valdobbiadene", alcohol, 850);
        Product coffee = new Product("Jacobs", drinks, 540);
        Product banana = new Product("Banana", fruits, 350);
        Product napoleon = new Product("Napoleon", cakes, 550);
        Product potato = new Product("Potato", vegetables, 55);

        warehouse.getProductMap().put(prosecco, 50);
        warehouse.getProductMap().put(coffee, 150);
        warehouse.getProductMap().put(banana, 400);
        warehouse.getProductMap().put(napoleon, 20);
        warehouse.getProductMap().put(potato, 1000);

        shop.setBank(1_000_000);

        ui.setShop(shop);
    }

    public void start(Client client) {

        ui.setClient(client);
        Scanner scanner = new Scanner(System.in);

        ui.displayMenu();
        boolean isEndOfShopping = false;
        System.out.println("Welcome to Shop!");

        while (!isEndOfShopping) {

            System.out.print("Select command: ");
            int currentOption = scanner.nextInt();
            scanner.nextLine();

            MenuCommand selectedCommand = ui.getMenuCommandByLabel(currentOption);
            if (selectedCommand == null) {
                System.out.println("Entered the wrong command. Try again");
                continue;
            }

            switch (selectedCommand) {
                case SHOW_PRODUCTS_TYPE:
                    ui.displayProductTypes();
                    break;
                case SHOW_PRODUCTS_BY_TYPE:
                    ui.displayProductsByType();
                    break;
                case ADD_ITEM_TO_BASKET:
                    boolean hasContinueShopping;
                    Map<Product, Integer> products = shop.getProducts();
                    do {

                        System.out.print("Select product: ");
                        String selectedItem = scanner.next();

                        System.out.printf("Select count of %s: ", selectedItem);
                        int selectedCount = scanner.nextInt();
                        scanner.nextLine();

                        ui.addItemToBasket(selectedItem, selectedCount, products, scanner);

                        hasContinueShopping = shouldExitLoop(scanner);
                    } while (hasContinueShopping);
                    break;
                case REMOVE_ITEM_FROM_BASKET:
                    boolean hasContinueRemoving;

                    Map<Product, Integer> basket = client.getBasket();
                    do {

                        System.out.print("Choose a way to remove: (product/count): ");
                        String chooseWayToRemove = scanner.nextLine();

                        if (chooseWayToRemove.equals("product")) {
                            System.out.print("Select product to remove: ");
                            String selectedProductToRemove = scanner.nextLine();
                            ui.removeItemFromBasket(selectedProductToRemove, basket);
                        } else if (chooseWayToRemove.equals("count")) {
                            System.out.print("Select product to remove: ");
                            String selectedProductToRemove = scanner.nextLine();

                            System.out.print("Select count to remove: ");
                            int selectedCountToRemove = scanner.nextInt();
                            scanner.nextLine();

                            ui.removeItemFromBasket(selectedProductToRemove, selectedCountToRemove, basket, scanner);
                        }

                        hasContinueRemoving = shouldExitLoop(scanner);
                    }while (hasContinueRemoving);
                    break;
                case SHOW_YOUR_BASKET:
                    ui.displayBasket();
                    break;
                case CHECKOUT:
                    ui.checkout();
                    break;
                case RETURN_PRODUCT:
                    System.out.print("Enter what product you want to return: ");
                    String productToReturn = scanner.nextLine();

                    System.out.print("Enter count: ");
                    int count = scanner.nextInt();
                    scanner.nextLine();

                    ui.returnProduct(productToReturn, count);
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
