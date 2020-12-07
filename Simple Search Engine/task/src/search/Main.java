package search;

public class Main {
    public static void main(String[] args) {
        String fileName = getFileName(args);
        SearchNgin searchNgin = new SearchNgin(fileName);
        searchNgin.run();
    }
    private static  String getFileName(String[] args) {
        for (int i = 0; i < args.length - 1; i++) {
            if ("--data".equals(args[i])) {
                return  args[i + 1];
            }
        }
        return  "";
    }


}
