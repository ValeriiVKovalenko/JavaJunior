package javarush.my_linkedlist;


import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(22);
        list.add(33);
        list.add(1);
        System.out.println(list.toString());
        list.remove(22);
        System.out.println(list.toString());
    }
}
