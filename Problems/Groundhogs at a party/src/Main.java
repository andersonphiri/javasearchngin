import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int cups = Integer.parseInt(scanner.next());
        boolean isWeekend = scanner.nextBoolean();
        boolean answer = isWeekend && (cups >= 15 && cups <= 25)
                            ||
                        !isWeekend && (cups >= 10 && cups <= 20);
        System.out.println(answer);
    }
}
