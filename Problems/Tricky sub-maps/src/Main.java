import java.util.*;

class MapUtils {
    public static Map<Integer, String> getSubMap(TreeMap<Integer, String> map) {
        // Write your code here
        Map<Integer, String> result;
        var first = map.firstKey();
        var last = map.lastKey();
        if (first % 2 == 0) {
            result = map.subMap(last - 4, true, last, true);
        } else {
            result = map.subMap(first, true, first + 4, true);
        }
        Map<Integer, String> answer = new TreeMap<>(Comparator.reverseOrder());
        answer.putAll(result);
        return answer;
    }
}

/* Do not modify code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Integer, String> map = new TreeMap<>();
        Arrays.stream(scanner.nextLine().split("\\s")).forEach(s -> {
            String[] pair = s.split(":");
            map.put(Integer.parseInt(pair[0]), pair[1]);
        });

        Map<Integer, String> res = MapUtils.getSubMap(map);
        res.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}