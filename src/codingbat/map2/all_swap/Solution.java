package codingbat.map2.all_swap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*

Мы будем говорить, что две строки "совпадают", если они непустые и их первые символы одинаковы. Переберите и верните
заданный массив непустых строк следующим образом: если строка совпадает с более ранней строкой в массиве, поменяйте
местами две строки в массиве. Если строка в массиве поменялась местами, она больше ни с чем не совпадает. Используя
карту, это можно решить, сделав всего один проход по массиву. Это сложнее, чем кажется.

allSwap(["ab", "ac"]) → ["ac", "ab"]
allSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) → ["ay", "by", "cy", "cx", "bx", "ax", "azz", "aaa"]
allSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) → ["ay", "by", "ax", "bx", "aj", "ai", "by", "bx"]
 */
public class Solution {

    public String[] allSwap(String[] strings) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            String current = strings[i];
            if (current.isEmpty()) {
                continue;
            }
            char firstChar = current.charAt(0);

            if (map.containsKey(firstChar)) {
                int prevIndex = map.get(firstChar);
                String temp = strings[prevIndex];
                strings[prevIndex] = current;
                strings[i] = temp;
                map.remove(firstChar);
            } else {
                map.put(firstChar, i);
            }
        }
        return strings;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] arr = {"ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"};
        System.out.println(Arrays.toString(solution.allSwap(arr)));
    }

}
