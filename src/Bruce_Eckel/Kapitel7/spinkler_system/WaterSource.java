package Bruce_Eckel.Kapitel7.spinkler_system;

public class WaterSource {
    private String s;

    public WaterSource() {
        System.out.println("WaterSource()");
        s = "сконструирован.";
    }

    public String toString() {
        return s;
    }
}
