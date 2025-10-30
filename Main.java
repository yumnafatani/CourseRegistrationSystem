import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String studentName = scanner.nextLine();

        int studentN = 0;
        while (true) {
            try {
                System.out.print("Enter your student Number: ");
                studentN = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer for student number.");
                scanner.next();
            }
        }

        int studentLevel = 0;
        while (true) {
            try {
                System.out.print("Enter your Level: ");
                studentLevel = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer for student level.");
                scanner.next();
            }
        }

        Student student1 = new Student(studentName, studentN, studentLevel);

        Course course1 = new Course("Algorithm", 3, 101);
        Course course2 = new Course("OOP", 4, 102);
        Course course3 = new Course("Web Development", 2, 103);
        Course course4 = new Course("Discrete Structures", 4, 104);
        Course course5 = new Course("Physics", 3, 105);

        Instructor instructor1 = new Instructor("Dr. Azhar Hassan");
        Instructor instructor2 = new Instructor("Dr. Yumna Fatani");
        Instructor instructor3 = new Instructor("Dr. Mariam Alghamdi");
        Instructor instructor4 = new Instructor("Dr. Shahad Alzahrani");

        course1.setClassTime1("2:15 PM - 4:15 PM");
        course2.setClassTime1("4:15 PM - 6:15 PM");
        course1.setClassTime2("8:00 AM - 10:00 AM");
        course2.setClassTime2("10:00 AM - 12:00 PM");
        course3.setClassTime2("12:00 PM - 2:00 PM");
        course4.setClassTime2("2:00 PM - 4:00 PM");

        boolean run = true;
        while (run) {
            System.out.println("\nWelcome to UQU System:");
            System.out.println("**********");
            System.out.println("1. Register for a course");
            System.out.println("2. View schedule");
            System.out.println("3. Remove a course");
            System.out.println("4. Display Information");
            System.out.println("5. Exit");
            System.out.println("**********");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please enter a number 1-5.");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1 -> {
                    boolean continueRegistering = true;
                    while (continueRegistering) {
                        System.out.println("Available Courses:");
                        System.out.println("1. " + course1.getCourseN() + " - " + course1.getCreditHours() + " Credit Hours - Code " + course1.getCourseCode());
                        System.out.println("2. " + course2.getCourseN() + " - " + course2.getCreditHours() + " Credit Hours - Code " + course2.getCourseCode());
                        System.out.println("3. " + course3.getCourseN() + " - " + course3.getCreditHours() + " Credit Hours - Code " + course3.getCourseCode());
                        System.out.println("4. " + course4.getCourseN() + " - " + course4.getCreditHours() + " Credit Hours - Code " + course4.getCourseCode());
                        System.out.println("5. " + course5.getCourseN() + " - " + course5.getCreditHours() + " Credit Hours - Code " + course5.getCourseCode());

                        int courseChoice;
                        try {
                            System.out.print("Choose a course (1-5): ");
                            courseChoice = scanner.nextInt();
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter a number between 1 and 5.");
                            scanner.next();
                            continue;
                        }

                        Course chosenCourse = switch (courseChoice) {
                            case 1 -> course1;
                            case 2 -> course2;
                            case 3 -> course3;
                            case 4 -> course4;
                            case 5 -> course5;
                            default -> null;
                        };

                        if (chosenCourse == null) {
                            System.out.println("Invalid course choice.");
                            continue;
                        }

                        System.out.println("Available Professors:");
                        System.out.println("1. " + instructor1.getIName());
                        System.out.println("2. " + instructor2.getIName());
                        System.out.println("3. " + instructor3.getIName());
                        System.out.println("4. " + instructor4.getIName());

                        int instructorChoice;
                        try {
                            System.out.print("Choose a professor (1-4): ");
                            instructorChoice = scanner.nextInt();
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter a number between 1 and 4.");
                            scanner.next();
                            continue;
                        }

                        Instructor chosenInstructor = switch (instructorChoice) {
                            case 1 -> instructor1;
                            case 2 -> instructor2;
                            case 3 -> instructor3;
                            case 4 -> instructor4;
                            default -> null;
                        };

                        if (chosenInstructor == null) {
                            System.out.println("Invalid professor choice.");
                            continue;
                        }

                        String t1 = chosenCourse.getClassTime1();
                        String t2 = chosenCourse.getClassTime2();

                        if ((t1 == null || t1.isBlank()) && (t2 == null || t2.isBlank())) {
                            student1.AssignCourse(chosenCourse, null, chosenInstructor);
                        } else {
                            System.out.println("Available Times for " + chosenCourse.getCourseN() + ":");
                            if (t1 != null && !t1.isBlank()) System.out.println("1. " + t1);
                            if (t2 != null && !t2.isBlank()) System.out.println("2. " + t2);

                            int timeChoice;
                            try {
                                System.out.print("Choose a time for the course (1-2): ");
                                timeChoice = scanner.nextInt();
                                scanner.nextLine();
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input! Please enter 1 or 2.");
                                scanner.next();
                                continue;
                            }

                            String chosenTime = switch (timeChoice) {
                                case 1 -> t1;
                                case 2 -> t2;
                                default -> null;
                            };

                            if (chosenTime == null || chosenTime.isBlank()) {
                                System.out.println("Invalid time choice.");
                                continue;
                            }

                            student1.AssignCourse(chosenCourse, chosenTime, chosenInstructor);
                        }

                        System.out.print("Do you want to register for another course? (yes/no): ");
                        String response = scanner.nextLine();
                        if (!response.equalsIgnoreCase("yes")) {
                            continueRegistering = false;
                        }
                    }
                }
                case 2 -> student1.Viewschedule();
                case 3 -> {
                    System.out.print("Enter Course Name: ");
                    String coursename = scanner.nextLine();
                    student1.RemoveCourse(coursename);
                }
                case 4 -> System.out.println(student1.printInfo());
                case 5 -> run = false;
                default -> System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
