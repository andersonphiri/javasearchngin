import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        final  Map<String, Integer> nuusWords = new HashMap<>();
        final  Map<String, Integer> myNote = new HashMap<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> addToHashMap(e, nuusWords));
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> addToHashMap(e, myNote));
        boolean isOk = isPossible(nuusWords, myNote);
        if (isOk) {
            System.out.println("You get money");
        } else {
            System.out.println("You are busted");
        }

    }
    static void addToHashMap(String key, Map<String, Integer> map) {
        int count;
        count = map.getOrDefault(key, 0);
        map.put(key, ++count);

    }
    static  boolean isPossible(Map<String, Integer> newspaper, Map<String, Integer> myNote) {
        for (Map.Entry<String, Integer> entry:
                myNote.entrySet()) {
            if (!newspaper.containsKey(entry.getKey()) || newspaper.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}