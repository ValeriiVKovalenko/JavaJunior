package Bruce_Eckel.Kapitel7.final_data;

import java.util.Random;

public class FinalData {

    private static Random random = new Random(47);
    private String id;

    public FinalData(String id) {
        this.id = id;
    }

    //Константа времени компеляции
    private final int valueOne = 9;
    private static final int VALUE_TWO = 99;

    //Открытая константа
    public static final int VALUE_THREE = 39;

    //НЕ может быть константой времени компеляции
    private final int i4 = random.nextInt(20);
    static final int INT_5 = random.nextInt(20);
    private Value value1 = new Value(1);
    private final Value value2 = new Value(22);
    private static final Value VAL_3 = new Value(33);

    // Массивы
    private final int[] arr = {1, 2, 3, 4, 5};

    public String toString() {
        return id + ": " + "i4 = " + i4 + " , INT_5 = " + INT_5;
    }

    public static void main(String[] args) {
        FinalData finalData = new FinalData("fd1");

//        finalData.valueOne++;
        finalData.value2.i++;
        finalData.value1 = new Value(9);

        for (int i = 0; i < finalData.arr.length; i++) {
            finalData.arr[i]++;
        }

//        finalData.value2 = new Value(0);
//        finalData.VAL_3 = new Value(1);
//        finalData.arr = new int[3];

        System.out.println(finalData);
        System.out.println("Создаем finalData");
        FinalData finalData2 = new FinalData("fd2");
        System.out.println(finalData);
        System.out.println(finalData2);
    }

}
