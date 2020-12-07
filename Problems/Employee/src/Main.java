class Employee {

    String name;
    int salary;
    String address;
    public Employee() {
        name = "unknown";
        address = "unknown";
        salary = 0;
    }
    public Employee(String name, int salary) {
        this();
        this.name = name;
        this.salary = salary;
    }
    public Employee(String name, int salary, String address) {
        this(name, salary);
        this.address = address;
    }
}