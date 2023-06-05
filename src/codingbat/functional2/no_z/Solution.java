package codingbat.functional2.no_z;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*

Если дан список строк, верните список строк, опуская все строки, содержащие букву "z".
(Примечание: метод str.contains(x) возвращает булево значение)

noZ(["aaa", "bbb", "aza"]) → ["aaa", "bbb"]
noZ(["hziz", "hzello", "hi"]) → ["hi"]
noZ(["hello", "howz", "are", "youz"]) → ["hello", "are"]
 */
public class Solution {
    public List<String> noZ(List<String> strings) {
        return strings.stream()
                .filter(e -> !e.contains("z"))
                .collect(Collectors.toList());
    }

}
