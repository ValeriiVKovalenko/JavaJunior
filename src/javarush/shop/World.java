package javarush.shop;

import javarush.shop.model.*;
import javarush.shop.service.shop.ShopServiceImp;
import javarush.shop.ui.UI;

import java.util.*;

public class World {
    private final List<Client> clientList = new ArrayList<>();
    private final Shop shop = new Shop();
    private final UI ui = new UI();

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

        ui.setShopService(new ShopServiceImp(shop, warehouse));
    }

    public void start(Client client) {
        ui.start(client);
    }
}
