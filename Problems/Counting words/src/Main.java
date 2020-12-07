import java.util.*;

class MapUtils {

    public static SortedMap<String, Integer> wordCount(String[] strings) {
        // write your code here
        SortedMap<String, Integer> answer = new TreeMap<>();
        int count;
        for (String string:
             strings) {
            count = answer.getOrDefault(string, 0);
            answer.put(string, ++count);
        }
        return  answer;
    }

    public static void printMap(Map<String, Integer> map) {
        // write your code here
        map.forEach((k, v) -> System.out.println(k + " : " + v));
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        MapUtils.printMap(MapUtils.wordCount(words));
    }
}
