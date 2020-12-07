import java.util.*;

interface Multiset<E> {

    /**
     * Add an element to the multiset.
     * It increases the multiplicity of the element by 1.
     */
    void add(E elem);

    /**
     * Remove an element from the multiset.
     * It decreases the multiplicity of the element by 1.
     */
    void remove(E elem);

    /**
     * Unite this multiset with another one. The result is the modified multiset (this).
     * It will contain all elements that are present in at least one of the initial multisets.
     * The multiplicity of each element is equal to the maximum multiplicity of
     * the corresponding elements in both multisets.
     */
    void union(Multiset<E> other);

    /**
     * Intersect this multiset with another one. The result is the modified multiset (this).
     * It will contain all elements that are present in the both multisets.
     * The multiplicity of each element is equal to the minimum multiplicity of
     * the corresponding elements in the intersecting multisets.
     */
    void intersect(Multiset<E> other);

    /**
     * Returns multiplicity of the given element.
     * If the set doesn't contain it, the multiplicity is 0
     */
    int getMultiplicity(E elem);

    /**
     * Check if the multiset contains an element,
     * i.e. the multiplicity > 0
     */
    boolean contains(E elem);

    /**
     * The number of unique elements,
     * that is how many different elements there are in a multiset.
     */
    int numberOfUniqueElements();

    /**
     * The size of the multiset, including repeated elements
     */
    int size();

    /**
     * The set of unique elements (without repeating)
     */
    Set<E> toSet();
}

class HashMultiset<E> implements Multiset<E> {

    private Map<E, Integer> map = new HashMap<>();

    @Override
    public void add(E elem) {
        // implement the method
        map.put(elem, map.getOrDefault(elem, 0) + 1);
    }

    @Override
    public void remove(E elem) {
        // implement the method
        if (!map.containsKey(elem)) {
            return;
        }
        int count = map.get(elem);
        if (count == 1) {
            map.remove(elem);
        } else {
            map.put(elem, count - 1);
        }

    }

    @Override
    public void union(Multiset<E> other) {
        // implement the method
        var keySet = other.toSet();
        int thisMultiplicity;
        int otherMultiplicity;
        for (E elem :
                keySet) {
            otherMultiplicity = other.getMultiplicity(elem);
            thisMultiplicity = this.getMultiplicity(elem);
            this.map.put(elem, Math.max(thisMultiplicity, otherMultiplicity));
        }
    }

    @Override
    public void intersect(Multiset<E> other) {
        // implement the method
        var keySet = other.toSet();
        int thisMultiplicity;
        int otherMultiplicity;
        Map<E, Integer> mapFinal  = new HashMap<>();
        for (E elem :
                keySet) {
            if (this.map.containsKey(elem)) {
                otherMultiplicity = other.getMultiplicity(elem);
                thisMultiplicity = this.getMultiplicity(elem);
                mapFinal.put(elem, Math.min(thisMultiplicity, otherMultiplicity));
            }
        }
        this.map = mapFinal;
    }

    @Override
    public int getMultiplicity(E elem) {
        // implement the method
        return map.getOrDefault(elem, 0);
    }

    @Override
    public boolean contains(E elem) {
        // implement the method
        return map.containsKey(elem);
    }

    @Override
    public int numberOfUniqueElements() {
        // implement the method
        return this.map.keySet().size();
    }

    @Override
    public int size() {
        // implement the method
        int total = 0;
        for (E elem :
                map.keySet()) {
            total += getMultiplicity(elem);

        }
        return total;
    }

    @Override
    public Set<E> toSet() {
        // Creating a new HashSet<> object helps us avoid ConcurrentModificationException.
        // It is thrown when we try to iterate over elements of Map and modify them at the same time
        return new HashSet<>(map.keySet());
    }
}