package codingbat.functional1.lower;

import java.util.List;
import java.util.stream.Collectors;

/*
Given a list of strings, return a list where each string is converted to lower case (Note: String toLowerCase() method).

lower(["Hello", "Hi"]) → ["hello", "hi"]
lower(["AAA", "BBB", "ccc"]) → ["aaa", "bbb", "ccc"]
lower(["KitteN", "ChocolaTE"]) → ["kitten", "chocolate"
 */
public class Solution {
    public List<String> lower(List<String> strings) {
        return strings.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

}
