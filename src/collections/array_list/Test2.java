package collections.array_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(100_000_000);

        for (int i = 0; i < 50_000_000; i++) {
            list.add(i);
        }
        long startTime = System.currentTimeMillis();
        list.remove(25_000_000);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;


        System.out.println("Заполение ArrayList: " + duration + "нс");

        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 50_000_000; i++) {
            linkedList.add(i);
        }
        long startTimeLL = System.currentTimeMillis();

        linkedList.remove(25_000_000);
        long endTimeLL = System.currentTimeMillis();
        long durationLL = endTimeLL - startTimeLL;


        System.out.println("Заполение LinkedList: " + durationLL + "нс");

    }
}
