import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        var list = Arrays.stream(scanner.nextLine().split("\\s+")).toArray();
        System.out.println(Arrays.toString(list));
    }
}