public class Course {
    private String courseN;
    private int creditHours;
    private int courseCode;
    private String classTime1;
    private String classTime2;

    public Course() {}

    public Course(String courseN, int creditHours, int courseCode) {
        this.courseN = courseN;
        this.creditHours = creditHours;
        this.courseCode = courseCode;
    }

    public Course(String classTime1, String classTime2) {
        this.classTime1 = classTime1;
        this.classTime2 = classTime2;
    }

    public String getCourseN() { return courseN; }
    public void setCourseN(String courseN) { this.courseN = courseN; }

    public int getCreditHours() { return creditHours; }
    public void setCreditHours(int creditHours) { this.creditHours = creditHours; }

    public int getCourseCode() { return courseCode; }
    public void setCourseCode(int courseCode) { this.courseCode = courseCode; }

    public String getClassTime1() { return classTime1; }
    public void setClassTime1(String classTime1) { this.classTime1 = classTime1; }

    public String getClassTime2() { return classTime2; }
    public void setClassTime2(String classTime2) { this.classTime2 = classTime2; }
}
