package codingbat.functional1.more_y;

import java.util.List;
import java.util.stream.Collectors;

/*
Given a list of strings, return a list where each string has "y" added at its start and end.

moreY(["a", "b", "c"]) → ["yay", "yby", "ycy"]
moreY(["hello", "there"]) → ["yhelloy", "ytherey"]
moreY(["yay"]) → ["yyayy"]
 */
public class Solution {
    public List<String> moreY(List<String> strings) {
        return strings.stream()
                .map(e -> "y" + e + "y")
                .collect(Collectors.toList());
    }
}
