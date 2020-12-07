package search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchAllStrategy implements ISearchStrategy {
    private final DataSource dataSource;
    public SearchAllStrategy(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public List<String[]> search(String[] queryWords) {
        List<String[]> result = new ArrayList<>();
        var indexes = getIntersection(queryWords);
        if (indexes.isEmpty()) {
            return  result;
        }
        indexes.forEach(index ->  result.add(this.dataSource.getData().get(index)));
        return result;
    }

    private Set<Integer> getIntersection(String[] queryWords) {
        if (queryWords.length == 1) {
            return this.dataSource.getInvertedIndex().getOrDefault(queryWords[0], new HashSet<>());
        } else if (queryWords.length == 0 || null == queryWords) {
            return new HashSet<Integer>();
        }
        // check first two elements
        Set<Integer> curr = this.dataSource.getInvertedIndex().getOrDefault(queryWords[0], new HashSet<>());
        Set<Integer> next = this.dataSource.getInvertedIndex().getOrDefault(queryWords[1], new HashSet<>());
        curr.retainAll(next);
        if (curr.isEmpty()) {
            return new HashSet<>();
        }
        String query;
        for (int i = 2; i < queryWords.length; i++) {
            query = queryWords[i];
            if (!this.dataSource.getInvertedIndex().containsKey(query)) {
                // stop immediately as there is no common intersection for all keys
                return new HashSet<>();
            }
            next = this.dataSource.getInvertedIndex().get(query);
            curr.retainAll(next);
            if (curr.isEmpty()) {
                // stop immediately as there is no common intersection for all keys
                return new HashSet<>();
            }

        }
        return  curr;
    }
}
