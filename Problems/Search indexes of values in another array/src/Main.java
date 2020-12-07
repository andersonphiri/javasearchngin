import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int[] searchIndexes(int[] first, int[] second) {
        // write your code here
        int[] resultArray = new int[first.length];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = firstOccurrenceIndex(second, first[i]);
        }

        return resultArray;
    }
    static  int firstOccurrenceIndex(int[] numbers, int value) {
        if (null == numbers || numbers.length == 0) {
            return -1;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (value == numbers[i]) {
                return i;
            }
        }
        return  -1;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int[] first = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        final int[] second = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        final String result = Arrays.toString(searchIndexes(first, second))
                .replace(", ", " ")
                .replace("[", "")
                .replace("]", "");
        System.out.println(result);
    }
}