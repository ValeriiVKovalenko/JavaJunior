package javarush.shop;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Cashier {

    private String name;
    private int ageExp; // лет опыта
    private Shop shop;
    private final Set<String> productTypes;

    public Cashier(String name, int ageExp, Shop shop) {
        this.name = name;
        this.ageExp = ageExp;
        this.shop = shop;
        productTypes = new HashSet<>();
    }

    public void sellItemToClient(Product product, int count, Client client, double balance) {
        if (shop.hasProduct(product) && canSellProduct(product)) {

            double currentPrice = product.getPrice() * count;
            if (client.getBalance() > currentPrice) {
                shop.setBank(shop.getBank() + currentPrice);
                client.setBalance(client.getBalance() - currentPrice);
                shop.transferItemToClient(product, count, this, client);
            } else {
                System.out.println("Insufficient funds in the account.");
            }
        }
    }

    public void returnProductFromClient(Product product, int count, Client client) {

        double currentPrice = product.getPrice() * count;
        shop.setBank(shop.getBank() - currentPrice);
        client.setBalance(client.getBalance() + currentPrice);

        client.removeItemFromBasket(product, count);
        shop.returnProductFromClient(product,count, client);
    }

    public boolean canSellProduct(Product product) {
        return productTypes.contains(product.getName());
    }

    public void addProductType(String productType) {
        productTypes.add(productType);
    }

    public Set<String> getProductTypes() {
        return productTypes;
    }

    public String getName() {
        return name;
    }

    public int getAgeExp() {
        return ageExp;
    }
}
