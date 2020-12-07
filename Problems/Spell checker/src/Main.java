import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner  = new Scanner(System.in);
        int d = Integer.parseInt(scanner.nextLine());
        Set<String> knowns = new HashSet<>();
        for (int i = 0; i < d; i++) {
            knowns.add(scanner.nextLine().toLowerCase());
        }
        int l = Integer.parseInt(scanner.nextLine());
        final List<String> texts = new ArrayList<>();
        String[] temp;
        for (int i = 0; i < l; i++) {
            temp = scanner.nextLine().split("\\s+");
            Arrays.stream(temp).forEach(e -> texts.add(e.toLowerCase()));
        }
        var answer = findErroneousWords(knowns, texts);
        answer.forEach(e -> System.out.println(e));
    }

    static Set<String> findErroneousWords(Set<String> knownWords, List<String> texts) {
        var t = texts.stream().filter(e -> !knownWords.contains(e))
                .collect(Collectors.toList());
        return  new HashSet<>(t);
    }
}
