package javarush.shop;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop(500_000);

        Client client = new Client("Valerii", 10_000, shop);

        Cashier cashier = new Cashier("Mirana", 10, shop);
        cashier.addProductType("bread");

        Cashier cashier2 = new Cashier("Lion", 5, shop);
        cashier2.addProductType("egg");

        Product product1 = new Product("bread", 20.00);
        Product product2 = new Product("egg", 50.00);

        shop.addProductToWarehouse(product1, 100);
        shop.addProductToWarehouse(product2, 600);

        shop.addCashier(cashier);
        shop.addCashier(cashier2);

        shop.printWarehouse();

        client.addItemToBasket(product1, 5);
        client.addItemToBasket(product1, 5);
        client.addItemToBasket(product2, 100);

        System.out.println(client.getBasket());

        client.buyItemFromBasket();
        System.out.println("Balance Client: " + client.getBalance());
        System.out.println("Bank Shop: "+ shop.getBank());
        System.out.println(client.getBasket());
        shop.printWarehouse();

        client.returnItemToShop(product1, 5);

        System.out.println("Client balance: " + client.getBalance());
        System.out.println("Shop bank: " + shop.getBank());
        shop.printWarehouse();
        client.findItemByName("wine");

    }
}
