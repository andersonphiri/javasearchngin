package search;

public class Person {
    private String firstName = "";
    private String surname = "";
    private  String email = "";

    @Override
    public  String toString() {
        return  firstName + " " + surname + " " + email;
    }
}
