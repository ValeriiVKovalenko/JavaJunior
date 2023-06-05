package codingbat.functional1.doubling;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
Given a list of integers, return a list where each integer is multiplied by 2.

doubling([1, 2, 3]) → [2, 4, 6]
doubling([6, 8, 6, 8, -1]) → [12, 16, 12, 16, -2]
doubling([]) → []
 */
public class Solution {
    public List<Integer> doubling(List<Integer> nums) {
        return nums.stream()
                .map(value -> value * 2)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(solution.doubling(list));
    }

}
