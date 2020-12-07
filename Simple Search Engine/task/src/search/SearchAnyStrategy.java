package search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchAnyStrategy implements ISearchStrategy {
    protected final DataSource dataSource;
    public SearchAnyStrategy(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public List<String[]> search(String[] queryWords) {
        var indexes = getUnionSet(queryWords);
        List<String[]> result = new ArrayList<>();
        if (indexes.isEmpty()) {
            return result;
        }
        indexes.forEach(index -> result.add(this.dataSource.getData().get(index)));
        return result;
    }

    protected Set<Integer> getUnionSet(String[] queryWords) {
        if (queryWords.length == 1) {
            return this.dataSource.getInvertedIndex().getOrDefault(queryWords[0], new HashSet<>());
        } else if (queryWords.length == 0 || null == queryWords) {
            return new HashSet<>();
        }
        // check first element
        Set<Integer> curr = this.dataSource.getInvertedIndex().getOrDefault(queryWords[0], new HashSet<>());
        String query;
        Set<Integer> temp;
        for (int i = 1; i < queryWords.length; i++) {
            query = queryWords[i];
            temp = this.dataSource.getInvertedIndex().getOrDefault(query, new HashSet<>());
            curr.addAll(temp);
        }
        return curr;
    }
}
