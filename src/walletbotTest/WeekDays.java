package walletbotTest;

import java.util.ArrayList;
import java.util.Comparator;

public enum WeekDays {
    MONDAY("bad"),
    TUESDAY("bad"),
    WEDNESDAY("so-so"),
    THURSDAY("so-so"),
    FRIDAY("so-so"),
    SATURDAY("great"),
    SUNDAY("great");

    private String mood;

    private WeekDays(String mood) {
        this.mood = mood;
    }
    public String getMood() {
        return mood;
    }


 }

