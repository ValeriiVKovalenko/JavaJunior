package codingbat.map2.first_swap;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Мы будем говорить, что две строки "совпадают", если они непустые и их первые символы одинаковы. Переберите и затем
верните заданный массив непустых строк следующим образом: если строка совпадает с более ранней строкой в массиве,
поменяйте местами две строки в массиве. Определенный первый символ может вызвать только одну замену, поэтому если
символ вызвал замену, последующие замены будут отключены. Используя карту, это можно решить, сделав всего один проход
по массиву. Это сложнее, чем кажется.

firstSwap(["ab", "ac"]) → ["ac", "ab"]
firstSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) → ["ay", "by", "cy", "cx", "bx", "ax", "aaa", "azz"]
firstSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) → ["ay", "by", "ax", "bx", "ai", "aj", "bx", "by"]
 */
public class Solution {

    public String[] firstSwap(String[] strings) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            String current = strings[i];

            if (current.isEmpty()) {
                continue;
            }

            char firstChar = current.charAt(0);

            if (map.containsKey(firstChar)) {
                int prevIndex = map.get(firstChar);

                if (prevIndex >= 0) {
                    String temp = strings[prevIndex];
                    strings[prevIndex] = current;
                    strings[i] = temp;
                    map.put(firstChar, -1);
                }

            } else {
                map.put(firstChar, i);
            }
        }
        return strings;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {"ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"};

        System.out.println(Arrays.toString(solution.firstSwap(arr)));
    }

}
