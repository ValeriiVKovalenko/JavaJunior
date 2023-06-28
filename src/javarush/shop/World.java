package javarush.shop;

import javarush.shop.ui.UI;

public class World {
    private final UI ui = new UI();

    public static void main(String[] args) {
        World world = new World();
        world.start();
    }
    public void start() {
        ui.start();
    }
}
