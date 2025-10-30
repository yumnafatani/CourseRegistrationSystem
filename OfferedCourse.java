public class OfferedCourse {
    private Course course;
    private String chosenTime;
    private Instructor instructor;

    public OfferedCourse() {}

    public OfferedCourse(Course course, String chosenTime, Instructor instructor) {
        this.course = course;
        this.chosenTime = chosenTime;
        this.instructor = instructor;
    }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public String getChosenTime() { return chosenTime; }
    public void setChosenTime(String chosenTime) { this.chosenTime = chosenTime; }

    public Instructor getInstructor() { return instructor; }
    public void setInstructor(Instructor instructor) { this.instructor = instructor; }

    @Override
    public String toString() {
        String cName = (course != null && course.getCourseN() != null) ? course.getCourseN() : "N/A";
        String cCode = (course != null) ? String.valueOf(course.getCourseCode()) : "N/A";
        String inst  = (instructor != null && instructor.getIName() != null) ? instructor.getIName() : "N/A";
        String time  = (chosenTime != null && !chosenTime.isBlank()) ? chosenTime : "No fixed time";
        return "Course: " + cName + " (Code " + cCode + "), Instructor: " + inst + ", Time: " + time;
    }
}
