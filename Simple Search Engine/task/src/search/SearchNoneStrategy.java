package search;

import java.util.*;

public class SearchNoneStrategy implements ISearchStrategy {
    protected final DataSource dataSource;
    public SearchNoneStrategy(DataSource dataSource) {
       this.dataSource = dataSource;
    }

    @Override
    public List<String[]> search(String[] queryWords) {
        var indexes = getNoneIndexes(queryWords);
        final List<String[]> result = new ArrayList<>();
        if (indexes.isEmpty()) {
            return result;
        }
        indexes.forEach(i -> result.add(this.dataSource.getData().get(i)));
        return result;
    }
    private Set<Integer> getNoneIndexes(String[] queryWords) {
        final Set<Integer> allUnion = new HashSet<>();
        this.dataSource.getInvertedIndex().values().forEach(e -> allUnion.addAll(e));
        Arrays.stream(queryWords).forEach(e -> {
            allUnion.removeAll(this.dataSource.getInvertedIndex().getOrDefault(e, new HashSet<>()));
        });
        return allUnion;
    }
}
