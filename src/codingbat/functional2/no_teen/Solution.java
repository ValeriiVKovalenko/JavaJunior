package codingbat.functional2.no_teen;

import java.util.List;
import java.util.stream.Collectors;

/*
Задав список целых чисел, верните список этих чисел, исключив все числа от 13 до 19 включительно.

noTeen([12, 13, 19, 20]) → [12, 20]
noTeen([1, 14, 1]) → [1, 1]
noTeen([15]) → []
 */
public class Solution {
    public List<Integer> noTeen(List<Integer> nums) {
        return nums.stream()
                .filter(e -> e < 13 || e > 19)
                .collect(Collectors.toList());
    }

}
