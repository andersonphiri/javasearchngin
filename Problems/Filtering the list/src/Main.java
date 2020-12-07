import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        var list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        final List<String> finalList = new ArrayList<>();
        int len = list.size();
        for (int i = len % 2 == 0 ? len - 1 : len - 2; i >= 1; i -= 2) {
            finalList.add(list.get(i));
        }
        finalList.forEach(x -> System.out.print(x + " "));

    }
}
