package javarush.enumExample;

public class EnumExample {
    private static final EnumExample MONDAY = new EnumExample(0);
    private static final EnumExample TUESDAY = new EnumExample(0);
    private static final EnumExample WEDNESDAY = new EnumExample(0);
    private static final EnumExample THURSDAY = new EnumExample(0);
    private static final EnumExample FRIDAY = new EnumExample(0);
    private static final EnumExample SATURDAY = new EnumExample(0);
    private static final EnumExample SUNDAY = new EnumExample(0);

    private static final EnumExample[] array = {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY};
    private final int value;


    private EnumExample(int value) {
        this.value = value;
    }

    public int ordinal() {
        return this.value;
    }

    public static EnumExample[] values() {
        return array;
    }

}
