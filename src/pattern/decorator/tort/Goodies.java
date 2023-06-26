package pattern.decorator.tort;

public abstract class Goodies implements Backing {
    public Backing backing;

    public Goodies(Backing backing) {
        this.backing = backing;
    }

    @Override
    public void about() {
        System.out.println(getDescription() + " " + getPrice() +"у.е.");
    }
}
