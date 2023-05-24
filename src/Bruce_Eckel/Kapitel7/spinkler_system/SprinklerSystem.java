package Bruce_Eckel.Kapitel7.spinkler_system;

public class SprinklerSystem {
    private String value1;
    private String value2;
    private String value3;
    private String value4;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;

    public String toString() {
        return "value1 = " + value1 + " " +
                "value2 = " + value2 + " " +
                "value3 = " + value3 + " " +
                "value4 = " + value4 + "\n" +
                "i = " + i + " " + "f = " + f + " " +
                "source = " + source;
    }

    public static void main(String[] args) {
        SprinklerSystem sprinklerSystem = new SprinklerSystem();
        System.out.println(sprinklerSystem);
    }

}
