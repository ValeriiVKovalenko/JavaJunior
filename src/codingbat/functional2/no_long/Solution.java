package codingbat.functional2.no_long;

import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<String> noLong(List<String> strings) {
        return strings.stream()
                .filter(e -> e.length() < 4)
                .collect(Collectors.toList());
    }

}
