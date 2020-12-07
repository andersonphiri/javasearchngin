package search;

import java.util.List;

public class SearchContext {
    private final ISearchStrategy strategy;

    public SearchContext(ISearchStrategy strategy) {
        this.strategy = strategy;
    }
    public List<String[]> search(String[] queryWords) {
        return this.strategy.search(queryWords);
    }
}
