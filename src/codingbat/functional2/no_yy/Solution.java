package codingbat.functional2.no_yy;

import java.util.List;
import java.util.stream.Collectors;

/*
noYY(["a", "b", "c"]) → ["ay", "by", "cy"]
noYY(["a", "b", "cy"]) → ["ay", "by"]
noYY(["xx", "ya", "zz"]) → ["xxy", "yay", "zzy"]
 */
public class Solution {
    public List<String> noYY(List<String> strings) {
        return strings.stream()
                .map(e -> e + "y")
                .filter(e -> !e.contains("yy"))
                .collect(Collectors.toList());
    }
}
