package codingbat.functional1.no_x;

import java.util.List;
import java.util.stream.Collectors;

/*
Given a list of strings, return a list where each string has all its "x" removed.

noX(["ax", "bb", "cx"]) → ["a", "bb", "c"]
noX(["xxax", "xbxbx", "xxcx"]) → ["a", "bb", "c"]
noX(["x"]) → [""]
 */
public class Solution {
    public List<String> noX(List<String> strings) {
        return strings.stream()
                .map(e -> e.replace("x", ""))
                .collect(Collectors.toList());
    }

}
