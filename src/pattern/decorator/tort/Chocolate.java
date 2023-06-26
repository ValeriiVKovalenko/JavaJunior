package pattern.decorator.tort;


public class Chocolate extends Goodies {
    public Chocolate(Backing backing) {
        super(backing);
    }

    @Override
    public int getPrice() {
        return 10 + backing.getPrice();
    }

    @Override
    public String getDescription() {
        return "с шоколадом";
    }
}
