public abstract class User {
    private String name;
    private int studentNumber;
    private int level;

    public User() {}

    public User(String name, int studentNumber, int level) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.level = level;
    }

    public String getName() { return name; }
    public int getStudentNumber() { return studentNumber; }
    public int getLevel() { return level; }

    public void setName(String name) { this.name = name; }
    public void setStudentNumber(int studentNumber) { this.studentNumber = studentNumber; }
    public void setLevel(int level) { this.level = level; }

    public abstract String printInfo();
}
