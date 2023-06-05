package javarush.my_arraylist;

import java.util.ArrayList;
import java.util.Arrays;

// remove(index) remove(Object);
// contains
// indexOf
// toArray

public class MyArrayList<T> {
    private static final int CAPACITY = 10;
    private static final int GROW_MULTIPLIER = 2;
    private Object[] array = new Object[CAPACITY];
    private int size;


    public T get(int index) {
        return (T) array[index];
    }

    public int size() {
        return size;
    }

    private void grow() {
        Object[] newArray = new Object[array.length * GROW_MULTIPLIER];
       System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
    public void add(T element) {
        if(isFull()) {
            grow();
        }
        array[size++] = element;
    }

    private boolean isFull() {
        return size == array.length;
    }

    public boolean contains(Object element) {
        for (Object o : array) {
            if( o == null) {
                continue;
            }
            if(o.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public Object[] toArray() {
       return Arrays.copyOf(array, array.length);
    }

    public int indexOf(T element) {
        for (int i = 0; i < array.length; i++) {

            if(array[i] == null) {
                continue;
            }
            if(array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public void printArray() {
        for (int i = 0; i < array.length; i++) {

            if(i == 0){
                System.out.print("[" + array[i] + ", ");
            } else if(i == array.length - 1) {
                System.out.print(array[i] + "]\n");
            }else {
                System.out.print(array[i] + ", ");
            }
        }
    }

    public void remove(int index) {
      Object[] newArray = new Object[array.length - 1];
      System.arraycopy(array, 0, newArray, 0, index);
      System.arraycopy(array, index + 1, newArray, index, newArray.length - index);
      array = newArray;
    }

    public void remove(T element) {
        int tempIndex = indexOf(element);
        remove(tempIndex);
    }
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.printArray();

        System.out.println(list.size);
        System.out.println(list.contains("D"));
        list.toArray();
        System.out.println(list.indexOf("B"));
        System.out.println("====");
        list.remove("A");
        list.printArray();
        System.out.println();
    }
}
