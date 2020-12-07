import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine().toLowerCase();
        String word2 = scanner.nextLine().toLowerCase();
        var areAnagrams = areEqual(getMapFromWord(word1), getMapFromWord(word2));
        if (areAnagrams) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
    static Map<Character, Integer> getMapFromWord(String word) {
        final Map<Character, Integer> result = new HashMap<>();
        Character temp;
        for (int i = 0; i < word.length(); i++) {
            temp = word.charAt(i);
            result.put(temp, result.getOrDefault(temp, 0) + 1);
        }
        return result;
    }
    static boolean areEqual(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        return  map1.equals(map2);
    }

}