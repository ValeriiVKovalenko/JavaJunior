package walletbotTest;

import java.util.ArrayList;
import java.util.Comparator;

public class Test {
    public static final int MONDAY = 1;
    void method(int dayOfTheWeek) {
        System.out.println("Today is " + dayOfTheWeek);
    }

    public static void main(String[] args) {
        Today t1 = new Today(WeekDays.SATURDAY);
        ArrayList<WeekDays> wlist = new ArrayList<>();
        t1.addToList(wlist, WeekDays.THURSDAY);
        t1.addToList(wlist, WeekDays.MONDAY);
        t1.addToList(wlist, WeekDays.SATURDAY);
        t1.addToList(wlist, WeekDays.SUNDAY);

        t1.sortList(wlist);
        System.out.println(wlist);


    }
}
class Today {
    WeekDays weekDay;

    public Today(WeekDays weekDay) {
        this.weekDay = weekDay;
    }
    private ArrayList<WeekDays> list = new ArrayList<>();
    public void addToList(ArrayList<WeekDays> list, WeekDays day) {
        list.add(day);
    }
    public ArrayList<WeekDays> sortList(ArrayList<WeekDays> list) {
        list.sort(new Comparator<WeekDays>() {
            @Override
            public int compare(WeekDays o1, WeekDays o2) {
                return o1.compareTo(o2);
            }
        });
        return list;
    }
}
