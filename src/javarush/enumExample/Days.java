package javarush.enumExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Days {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public static List<Days> asList() {
        ArrayList<Days> days = new ArrayList<>();
        Collections.addAll(days, values());
        return days;
    }
}
