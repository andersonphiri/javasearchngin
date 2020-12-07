import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = readArray(scanner.nextLine());
        int value = scanner.nextInt();

        int index = findIndex(numbers, value);
        System.out.println(index);
    }

    static int findIndex(int[] numbers, int value) {
        // implement me
        int result = -1;
        if (numbers.length <= 1 && value != numbers[0]) {
            return -1;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (value == numbers[i]) {
                result = i;
            }
        }
        //return Arrays.binarySearch(numbers, value);

        return result;
    }

    // utility class for parsing int[], do not change it
    private static int[] readArray(String line) {
        String[] strings = line.trim().split(" ");
        int[] numbers = new int[strings.length];

        for (int i = 0; i < strings.length; i++)
            numbers[i] = Integer.parseInt(strings[i]);

        return numbers;
    }
}