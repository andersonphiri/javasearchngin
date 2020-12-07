import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split("\\s+");
        int lower = Integer.parseInt(s[0]);
        int upper = Integer.parseInt(s[1]);
        int len = Integer.parseInt(scanner.nextLine());
        Map<Integer, String> data = new TreeMap<>();
        String[] temp;
        for (int i = 0; i < len; i++) {
            temp = scanner.nextLine().split("\\s+");
            data.put(Integer.parseInt(temp[0]), temp[1]);
        }
        Map<Integer, String> answer = getInRange(data, lower, upper);
        printMap(answer);
    }
    static Map<Integer, String> getInRange(Map<Integer, String> sortedSource, int lowerKey, int upperKey) {
        Map<Integer, String> answer = new TreeMap<>();
        String value;
        for (int i = lowerKey; i <= upperKey; i++) {
            value = sortedSource.get(i);
            if (null != value) {
                answer.put(i, value);
            }

        }
        return answer;
    }
    static  void printMap(Map<Integer, String> map) {
        map.forEach((k, v) -> System.out.println(k + " " + v));
    }
}