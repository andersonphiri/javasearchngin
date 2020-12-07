package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SearchNgin {
    private final String fileName;
    private final DataSource dataSource;
    public SearchNgin(String fileName) {
        dataSource = new DataSource();
        this.fileName = fileName;
    }

    public void run() {
        readFile();
        Scanner scanner = new Scanner(System.in);
        doStuff(scanner);
    }

    private  void doStuff(Scanner systemInScanner) {
        System.out.println();
        printMenu(systemInScanner);
    }
    private void addToInvertedIndex(String[] line, int lineNumber) {
        this.dataSource.addKeys(line, lineNumber);
        this.dataSource.addData(line);
    }
    private void readFile() {
        File sourceFile = new File(this.fileName);
        String[] tempArray;
        Scanner scan = null;
        int startIndex = 0;

        try{
            scan = new Scanner(sourceFile);
            while (scan.hasNext()) {
                tempArray = scan.nextLine().split("\\s+");
                addToInvertedIndex(tempArray, startIndex);
                startIndex++;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            scan.close();
        }
        finally {
            scan.close();
        }
    }
    private  void findPerson(SearchContext context) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a name or email to search all suitable people.");
        String[] key = scan.nextLine().toLowerCase().split("\\s+");
        System.out.println();
       // performSearch(this.data, key);
        performSearchWithIndexMap(key, context);
    }
    private void performSearchWithIndexMap(String[] keys, SearchContext context) {
        List<String[]> records = context.search(keys);
        printResults(records);
    }
    private void printMenu(Scanner systemInScanner) {
        System.out.println("=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit.");
        processMenu(systemInScanner);
    }
    private void processMenu(Scanner systemInScanner) {
        int option = Integer.parseInt(systemInScanner.nextLine());
        switch (option) {
            case 1:
                System.out.println("Select a matching strategy: ALL, ANY, NONE");
                String userSearchOption = systemInScanner.nextLine();
                handleSearching(userSearchOption);
                printMenu(systemInScanner);
                break;
            case 2:
                printResults(this.dataSource.getData());
                printMenu(systemInScanner);
                break;
            case 0:
                System.out.println();
                System.out.println("Bye!");
                System.exit(0);
                break;
            default:
                System.out.println("Incorrect option! Try again.");
                printMenu(systemInScanner);
                break;

        }
    }

    private void handleSearching(String userSearchOption) {
        switch (userSearchOption) {
            case "ANY":
                findPerson(new SearchContext( new SearchAnyStrategy(this.dataSource)));
                break;
            case "ALL":
                findPerson(new SearchContext( new SearchAllStrategy(this.dataSource)));
                break;
            case "NONE":
                findPerson(new SearchContext( new SearchNoneStrategy(this.dataSource)));
                break;
            default:
                break;
        }

    }

    private static void printResults(List<String[]> source) {
        if (source.isEmpty()) {
            System.out.println("No matching people found.");
            return;
        }
        System.out.println(source.size()+" persons found:");
        for (String[] line:
                source) {
            System.out.println(Arrays.toString(line)
                    .replace("[", "")
                    .replace("]", "")
                    .replace(", "," ")
            );
        }
    }

}
