import java.util.*;
import java.util.stream.Collectors;

class ListUtils {

    /**
     * It splits the passed list into a sequence of sublists with a predefined size 
     */
    public static <T> List<List<T>> splitListIntoSubLists(List<T> list, int subListSize) {
        List<List<T>> sublists = new ArrayList<>();

        // write your code here
        int size = list.size();

        if (subListSize >= size) {
            sublists.add(list);
            return sublists;
        }
        int startIndex = 0;
        int startEndIndex = subListSize;
        List<T> temp = null;
        while (startIndex < size && startEndIndex < size) {
            temp = list.subList(startIndex, startEndIndex);
            sublists.add(temp);
            startIndex = startEndIndex;
            startEndIndex = startIndex + subListSize;
        }
        var stub = list.stream().skip(startIndex).collect(Collectors.toList());
        if (stub.isEmpty()) {
            return  sublists;
        }
        sublists.add(stub);

        return sublists;
    }
}

/* Please, do not modify code in this class */
public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String[] values = scanner.nextLine().split("\\s+");

        final List<Integer> list = Arrays.asList(values).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        final int subListSize = Integer.parseInt(scanner.nextLine());

        final List<List<Integer>> subLists = ListUtils.splitListIntoSubLists(list, subListSize);

        subLists.forEach(subList -> {
            final String representation = subList.stream().map(Object::toString).collect(Collectors.joining(" "));
            System.out.println(representation);
        });
    }
}
