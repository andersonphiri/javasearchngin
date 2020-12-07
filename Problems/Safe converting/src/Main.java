import java.util.Scanner;

public class Main {

    public static int convert(Long val) {
        // write your code here
        if (null == val) {
            return 0;
        } else if (val > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (val < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) val.longValue();
    }


    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String val = scanner.nextLine();
        Long longVal = "null".equals(val) ? null : Long.parseLong(val);
        System.out.println(convert(longVal));
        Long l = new Long(123);
    }
}