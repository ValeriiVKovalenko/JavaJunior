package Bruce_Eckel.Kapitel7.plate;

public class PlaceSettings extends Custom {

    private Spoon spoon;
    private Fork fork;
    private Knife knife;
    private DinnerPlate dinnerPlate;

    public PlaceSettings(int i) {
        super(i + 1);
        spoon = new Spoon(i + 2);
        fork = new Fork(i + 3);
        knife = new Knife(i + 4);
        dinnerPlate = new DinnerPlate(i + 5);
        System.out.println("Constructor PlaceSettings");
    }

    public static void main(String[] args) {
        PlaceSettings placeSettings = new PlaceSettings(9);
    }
}
