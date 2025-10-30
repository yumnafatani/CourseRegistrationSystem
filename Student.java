import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Student extends User {
    private final List<OfferedCourse> schedule = new ArrayList<>();

    public Student() {}

    public Student(String name, int studentNumber, int level) {
        super(name, studentNumber, level);
    }

    public void AssignCourse(Course course, String chosenTime, Instructor instructor) {
        if (course == null || instructor == null) {
            System.out.println("Cannot assign: course/instructor is null.");
            return;
        }
        for (OfferedCourse oc : schedule) {
            boolean sameCourse = oc.getCourse() != null
                    && course.getCourseN() != null
                    && course.getCourseN().equalsIgnoreCase(oc.getCourse().getCourseN());
            boolean sameTime = (chosenTime == null && oc.getChosenTime() == null)
                    || (chosenTime != null && chosenTime.equalsIgnoreCase(oc.getChosenTime()));
            if (sameCourse && sameTime) {
                System.out.println("Already registered: " + course.getCourseN() +
                        (chosenTime != null ? " at " + chosenTime : ""));
                return;
            }
        }
        OfferedCourse oc = new OfferedCourse(course, chosenTime, instructor);
        schedule.add(oc);
        System.out.println("Registered: " + oc);
    }

    public void RemoveCourse(String courseName) {
        if (courseName == null || courseName.isBlank()) {
            System.out.println("Course name cannot be empty.");
            return;
        }
        boolean removed = false;
        Iterator<OfferedCourse> it = schedule.iterator();
        while (it.hasNext()) {
            OfferedCourse oc = it.next();
            if (oc.getCourse() != null
                    && oc.getCourse().getCourseN() != null
                    && oc.getCourse().getCourseN().equalsIgnoreCase(courseName)) {
                it.remove();
                removed = true;
            }
        }
        if (removed) {
            System.out.println("Removed all registrations for course: " + courseName);
        } else {
            System.out.println("No registrations found for course: " + courseName);
        }
    }

    public void Viewschedule() {
        if (schedule.isEmpty()) {
            System.out.println("Your schedule is empty.");
            return;
        }
        System.out.println("=== Your Schedule ===");
        for (OfferedCourse oc : schedule) {
            System.out.println(oc);
        }
    }

    @Override
    public String printInfo() {
        return "Student Name: " + getName() +
               ", Number: " + getStudentNumber() +
               ", Level: " + getLevel() +
               ", Registered Courses: " + schedule.size();
    }

    public List<OfferedCourse> getSchedule() {
        return Collections.unmodifiableList(schedule);
    }
}
