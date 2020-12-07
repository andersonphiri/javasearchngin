
class Counter {

    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
        // implement the method
        var count1 = list1.stream().filter(e -> e == elem).count();
        var count2 = list2.stream().filter(e -> e == elem).count();
        return count1 == count2;
    }
}
