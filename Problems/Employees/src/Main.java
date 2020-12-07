class Employee {

    // write fields
    private String name;
    private String email;
    private int experience;

    // write constructor
public Employee(String name, String email, int experience) {
    this.name = name;
    this.email = email;
    this.experience = experience;
}
    // write getters

    public int getExperience() {
        return experience;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}

class Developer extends Employee {

    // write fields
    private String mainLanguage;
    private String[] skills;
    // write constructor
    public  Developer(String name, String email, int experience,
                      String mainLanguage, String[] skills) {
        super(name, email, experience);
        this.mainLanguage = mainLanguage;
        this.skills = new String[skills.length];
        System.arraycopy(skills, 0, this.skills, 0, skills.length);
    }
    // write getters

    public String getMainLanguage() {
        return mainLanguage;
    }

    public String[] getSkills() {
        String[] result = new String[this.skills.length];
        System.arraycopy(this.skills, 0, result, 0, this.skills.length);
        return result;
    }
}

class DataAnalyst extends Employee {

    // write fields
    private  boolean phd;
    private String[] methods;

    // write constructor
public DataAnalyst(String name, String email, int experience, boolean phd, String[] methods) {
    super(name, email, experience);
    this.phd = phd;
    this.methods = new String[methods.length];
    System.arraycopy(methods, 0, this.methods, 0, methods.length);
}
    // write getters

    public String[] getMethods() {
    String[] result = new String[this.methods.length];
    System.arraycopy(this.methods, 0, result, 0, methods.length);
        return result;
    }

    public boolean isPhd() {
        return phd;
    }
}