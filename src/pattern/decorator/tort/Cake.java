package pattern.decorator.tort;

public class Cake implements Backing {
    @Override
    public int getPrice() {
        return 100;
    }

    @Override
    public String getDescription() {
        return "Торт";
    }

    @Override
    public void about() {
        System.out.println(getDescription() + " " + getPrice() +"у.е.");
    }
}
