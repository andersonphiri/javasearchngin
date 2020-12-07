package search;

import java.util.List;

public interface ISearchStrategy {
    List<String[]> search(String[] queryWords);
}
