import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner  = new Scanner(System.in);
        int d = Integer.parseInt(scanner.nextLine());
        Set<String> words = new TreeSet<>();
        for (int i = 0; i < d; i++) {
            words.add(scanner.nextLine());
        }
        words.forEach(word -> System.out.println(word));
    }
}
