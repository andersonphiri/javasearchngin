import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        var words = scanner.nextLine().split("\\s+");
        var answer = getKeyCount(words);
        answer.forEach((k, v) -> System.out.println(k + " " + v));
    }
    static Map<String, Integer> getKeyCount(String[] words) {
        Map<String, Integer> answer = new HashMap<>();
        String temp;
        for (String word :
                words) {
            temp = word.toLowerCase();
            answer.put(temp, answer.getOrDefault(temp, 0) + 1);
        }
        return answer;
    }
}
