package pattern.decorator.tort;

import pattern.decorator.tort.Goodies;

public class Cream extends Goodies {
    public Cream(Backing backing) {
        super(backing);
    }

    @Override
    public int getPrice() {
        return 12 + backing.getPrice();
    }

    @Override
    public String getDescription() {
        return "с кремом";
    }
}
