package Bruce_Eckel.Kapitel7.spaceship;

public class SpaceShip extends SpaceShipControls {

    private String name;

    public SpaceShip(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        SpaceShip spaceShip = new SpaceShip("NSEA Protector");
        spaceShip.forward(100);
    }
}
