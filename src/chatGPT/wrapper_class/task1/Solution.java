package chatGPT.wrapper_class.task1;
/*
Напишите программу, которая принимает целое число в качестве аргумента и увеличивает его на 5. Затем выведите результат
на экран.
 */
public class Solution {
    public void incr(Integer i) {
        i += 5;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Integer x = 10;
        solution.incr(x);
        System.out.println(x);
    }
}
