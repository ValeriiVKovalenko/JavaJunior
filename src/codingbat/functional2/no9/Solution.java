package codingbat.functional2.no9;

import java.util.List;
import java.util.stream.Collectors;

/*
Задав список целых неотрицательных чисел, верните список этих чисел, исключив все, которые заканчиваются на 9.

no9([1, 2, 19]) → [1, 2]
no9([9, 19, 29, 3]) → [3]
no9([1, 2, 3]) → [1, 2, 3]
 */
public class Solution {
    public List<Integer> no9(List<Integer> nums) {
        return nums.stream()
                .filter(e -> e %10 != 9)
                .collect(Collectors.toList());
    }

}
