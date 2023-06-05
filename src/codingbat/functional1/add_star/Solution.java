package codingbat.functional1.add_star;

import java.util.List;
import java.util.stream.Collectors;

/*
Given a list of strings, return a list where each string has "*" added at its end.

addStar(["a", "bb", "ccc"]) → ["a*", "bb*", "ccc*"]
addStar(["hello", "there"]) → ["hello*", "there*"]
addStar(["*"]) → ["**"]
 */
public class Solution {
    public List<String> addStar(List<String> strings) {

        return strings.stream()
                .map(element -> element + "*")
                .collect(Collectors.toList());
    }

}
