import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        final ArrayList<Integer> s = new ArrayList<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(num -> {
            s.add(Integer.parseInt(num));
        });
        int key = Integer.parseInt(scanner.nextLine());
        var answer = driver(s, key);
        System.out.println(Arrays.toString(answer.toArray())
            .replace("[", "")
            .replace("]", "")
            .replace(", ", " ")
        );
    }
    static ArrayList<Integer> driver(ArrayList<Integer> source, int key) {
        var insights = getInsights(source, key);
        switch (insights.getKeyScenario()) {
            case LEFT:
                return computeNearestAndSortWhenKeyIsOutsideRangeLeft(insights);
            case RIGHT:
                return computeNearestAndSortWhenKeyIsOutsideRangeRight(insights);
            case WITHIN:
                return computeNearestNeighborsAndSortAscending(source, key);
            case WITHIN_AND_CONTAINED:
                return getAllEqualToKey(insights, key);
            default:
                return new ArrayList<>();
        }
    }
    private static int getMin(ArrayList<Integer> list) {
        ArrayList<Integer> copy = (ArrayList<Integer>) (list.clone());
        Collections.sort(copy);
        return copy.get(0);
    }

    private static  ArrayList<Integer> getDiffs(ArrayList<Integer> source, int key) {
        ArrayList<Integer> differences = new ArrayList<>();
        for (int a: source) {
            differences.add(Math.abs(a - key));
        }
        return differences;
    }
    private static  ArrayList<Integer> computeNearestNeighborsAndSortAscending(
        ArrayList<Integer> source, int key) {
        var differences = getDiffs(source, key);
        //to avoid changing state, create copy and sort the copy to get min
        int minimumElement = getMin(source);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < source.size(); i++) {
            if (differences.get(i) == minimumElement) {
                result.add(source.get(i));
            }
        }
        Collections.sort(result);
        return result;
    }
    private static ArrayList<Integer> computeNearestAndSortWhenKeyIsOutsideRangeRight(
            SourceProp<Integer, KeyScenario, List<Integer>> sourceCollectionInsight) {
        if (sourceCollectionInsight.getMax() == sourceCollectionInsight.getMin()) {
            return (ArrayList<Integer>) sourceCollectionInsight.getSortedCollection();
        }
        ArrayList<Integer> results = new ArrayList<>();
        int index = sourceCollectionInsight.getSize() - 1;
        int next = sourceCollectionInsight.getMax();
        int max = next;
        while (next == max && index >= 1) {
            results.add(next);
            index = index - 1;
            next = sourceCollectionInsight.getSortedCollection().get(index);
        }
        return results;
    }
    private static ArrayList<Integer> computeNearestAndSortWhenKeyIsOutsideRangeLeft(
            SourceProp<Integer, KeyScenario, List<Integer>> sourceCollectionInsight) {
        if (sourceCollectionInsight.getMax() == sourceCollectionInsight.getMin()) {
            return (ArrayList<Integer>) sourceCollectionInsight.getSortedCollection();
        }
        ArrayList<Integer> results = new ArrayList<>();
        int index = 0;
        int next = sourceCollectionInsight.getMin();
        int min = next;
        int length = sourceCollectionInsight.getSize();
        while (next == min && index < length) {
            results.add(next);
            next = sourceCollectionInsight.getSortedCollection().get(++index);
        }
        return results;
    }

    private static ArrayList<Integer> getAllEqualToKey(
            SourceProp<Integer, KeyScenario, List<Integer>> sourceCollectionInsight, int key) {
        //O(n)
        if (!sourceCollectionInsight.isKeyContained()) {
            return new ArrayList<>();
        }
        ArrayList<Integer> integers = new ArrayList<>();
        // iterate from first index of key
        int keyIndex = sourceCollectionInsight.getKeyIndexIfContained();
        int next = sourceCollectionInsight.sortedCollection.get(keyIndex);
        while (next == key && keyIndex < sourceCollectionInsight.getSize()) {
            integers.add(next);
            next = sourceCollectionInsight.sortedCollection.get(++keyIndex);
        }
        return  integers;
    }
    private static SourceProp<Integer, KeyScenario, List<Integer>> getInsights(ArrayList<Integer> source, int key) {
        ArrayList<Integer> copy = (ArrayList<Integer>) (source.clone());
        Collections.sort(copy);
        int size = copy.size();
        int min = copy.get(0);
        int max = copy.get(size - 1);
        KeyScenario scenario = KeyScenario.WITHIN;
        SourceProp<Integer, KeyScenario, List<Integer>>  result = new SourceProp<>();
        result.setSortedCollection(copy);
        result.setMax(max);
        result.setMin(min);
        result.setSize(size);
        result.setKeyScenario(scenario);
        int keyIndex = Collections.binarySearch(copy, key);
        if (keyIndex >= 0) {
            result.setKeyIndexIfContained(keyIndex);
            result.setKeyContained(true);
            result.setKeyScenario(KeyScenario.WITHIN_AND_CONTAINED);
            return result;
        } else if (key < min) {
            result.setKeyScenario(KeyScenario.LEFT);
            return result;
        } else if (key > max) {
            result.setKeyScenario(KeyScenario.RIGHT);
            return result;
        }
        return result;
    }



}
enum KeyScenario {
    LEFT, WITHIN, WITHIN_AND_CONTAINED, RIGHT
}
class SourceProp<T, S, U> {
    T size;
    T min;
    T max;
    S keyScenario;
    U sortedCollection;
    boolean keyContained;
    int keyIndexIfContained;

    public  SourceProp() {
        keyIndexIfContained = -1;
        keyContained = false;
    }

    public int getKeyIndexIfContained() {
        return keyIndexIfContained;
    }

    public void setKeyIndexIfContained(int keyIndexIfContained) {
        this.keyIndexIfContained = keyIndexIfContained;
    }

    public boolean isKeyContained() {
        return keyContained;
    }

    public void setKeyContained(boolean keyContained) {
        this.keyContained = keyContained;
    }

    public T getSize() {
        return size;
    }

    public S getKeyScenario() {
        return keyScenario;
    }

    public T getMax() {
        return max;
    }

    public T getMin() {
        return min;
    }

    public U getSortedCollection() {
        return sortedCollection;
    }

    public void setSortedCollection(U sortedCollection) {
        this.sortedCollection = sortedCollection;
    }

    public void setKeyScenario(S keyScenario) {
        this.keyScenario = keyScenario;
    }

    public void setMax(T max) {
        this.max = max;
    }

    public void setMin(T min) {
        this.min = min;
    }

    public void setSize(T size) {
        this.size = size;
    }
}
