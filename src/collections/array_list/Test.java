package collections.array_list;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {

    private Object[] arr;
    private int size;
    private Object[] empty = {};

    public Test(Object[] arr) {
        this.arr = arr;
    }

    public void trimArrayToSize() {

        if(size < arr.length) {
            arr = (size == 0) ? empty : Arrays.copyOf(arr, size);
        }
    }

    @Override
    public String toString() {
        return "Test{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                ", empty=" + Arrays.toString(empty) +
                '}';
    }

    public static void main(String[] args) {
        Integer[] arr = {4, 2, 1, 5, 1, 3, 5};
        Test test = new Test(arr);

        test.trimArrayToSize();

        System.out.println(Arrays.toString(arr));
    }
}
