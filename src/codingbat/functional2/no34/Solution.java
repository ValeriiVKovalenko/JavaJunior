package codingbat.functional2.no34;

import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<String> no34(List<String> strings) {

        return strings.stream()
                .filter(e -> e.length() < 3 || e.length() > 4)
                .collect(Collectors.toList());
    }
}
