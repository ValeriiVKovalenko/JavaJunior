package codingbat.functional1.right_digit;

import java.util.List;
import java.util.stream.Collectors;

/*
Given a list of non-negative integers, return an integer list of the rightmost digits. (Note: use %)

rightDigit([1, 22, 93]) → [1, 2, 3]
rightDigit([16, 8, 886, 8, 1]) → [6, 8, 6, 8, 1]
rightDigit([10, 0]) → [0, 0]
 */
public class Solution {
    public List<Integer> rightDigit(List<Integer> nums) {

        return nums.stream()
                .map(e -> e %10)
                .collect(Collectors.toList());
    }
}
