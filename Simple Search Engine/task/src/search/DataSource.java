package search;

import java.util.*;

public class DataSource {
    private final List<String[]> data;
    private final Map<String, Set<Integer>> invertedIndex;
    public DataSource() {
            this.data = new ArrayList<>();
            this.invertedIndex = new HashMap<>();
    }

    public List<String[]> getData() {
        return data;
    }

    public Map<String, Set<Integer>> getInvertedIndex() {
        return invertedIndex;
    }
    public void addData(String[] line) {
        this.data.add(line);
    }
    public void addKeys(String[] line, int lineNumber) {
        Arrays.stream(line).forEach(e -> {
            Set<Integer> s;
            String key = e.toLowerCase().trim();
            if (!this.invertedIndex.containsKey(key)) {
                s = new HashSet<>();

            }
            else {
                s = this.invertedIndex.get(key);
            }
            s.add(lineNumber);
            this.invertedIndex.put(key, s);

        });
    }
}
