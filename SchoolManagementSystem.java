import java.util.ArrayList;
import java.util.Scanner;

// Student Class
class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String className;
    private String phone;
    private double attendance;
    private double averageMarks;

    public Student(int id, String name, int age, String gender,
                   String className, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.className = className;
        this.phone = phone;
        this.attendance = 0;
        this.averageMarks = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setAttendance(double attendance) {
        this.attendance = attendance;
    }

    public void setAverageMarks(double averageMarks) {
        this.averageMarks = averageMarks;
    }

    public double getAttendance() {
        return attendance;
    }

    public double getAverageMarks() {
        return averageMarks;
    }

    public void display() {
        System.out.println("--------------------------------------");
        System.out.println("Student ID       : " + id);
        System.out.println("Name             : " + name);
        System.out.println("Age              : " + age);
        System.out.println("Gender           : " + gender);
        System.out.println("Class            : " + className);
        System.out.println("Phone            : " + phone);
        System.out.println("Attendance       : " + attendance + "%");
        System.out.println("Average Marks    : " + averageMarks);
        System.out.println("--------------------------------------");
    }
}

// Teacher Class
class Teacher {
    private int id;
    private String name;
    private String subject;
    private String phone;

    public Teacher(int id, String name, String subject, String phone) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.phone = phone;
    }

    public void display() {
        System.out.println("--------------------------------------");
        System.out.println("Teacher ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Subject    : " + subject);
        System.out.println("Phone      : " + phone);
        System.out.println("--------------------------------------");
    }
}

// Performance Analyzer
class PerformanceAnalyzer {

    public static String calculateGrade(double marks) {

        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public static String analyze(double marks, double attendance) {

        if (marks >= 85 && attendance >= 90) {
            return "Excellent Performer";
        } else if (marks >= 70 && attendance >= 75) {
            return "Good Performer";
        } else if (marks >= 70 && attendance < 75) {
            return "Good Marks - Improve Attendance";
        } else if (marks < 50 && attendance < 75) {
            return "Needs Immediate Attention";
        } else if (marks < 50) {
            return "Needs Academic Improvement";
        } else {
            return "Average Performer";
        }
    }
}

// Main Class
public class SchoolManagementSystem {

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Teacher> teachers = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {
            displayMenu();

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    addTeacher();
                    break;

                case 5:
                    viewTeachers();
                    break;

                case 6:
                    updateAttendance();
                    break;

                case 7:
                    updateMarks();
                    break;

                case 8:
                    performanceAnalysis();
                    break;

                case 9:
                    showStatistics();
                    break;

                case 10:
                    System.out.println("\nThank you for using SmartEdu!");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }

        } while (choice != 10);

        scanner.close();
    }

    // Display Main Menu
    static void displayMenu() {

        System.out.println("\n==============================================");
        System.out.println("       SMARTEDU SCHOOL MANAGEMENT SYSTEM");
        System.out.println("==============================================");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Add Teacher");
        System.out.println("5. View All Teachers");
        System.out.println("6. Update Attendance");
        System.out.println("7. Update Marks");
        System.out.println("8. Performance Analysis");
        System.out.println("9. School Statistics");
        System.out.println("10. Exit");
        System.out.println("==============================================");
    }

    // Add Student
    static void addStudent() {

        System.out.println("\n========== ADD STUDENT ==========");

        int id = readInt("Enter Student ID: ");

        if (findStudent(id) != null) {
            System.out.println("Student ID already exists!");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        int age = readInt("Enter Age: ");

        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter Class: ");
        String className = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        Student student = new Student(
                id,
                name,
                age,
                gender,
                className,
                phone
        );

        students.add(student);

        System.out.println("\nStudent added successfully!");
    }

    // View Students
    static void viewStudents() {

        System.out.println("\n========== STUDENT LIST ==========");

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student student : students) {
            student.display();
        }
    }

    // Search Student
    static void searchStudent() {

        System.out.println("\n========== SEARCH STUDENT ==========");

        int id = readInt("Enter Student ID: ");

        Student student = findStudent(id);

        if (student != null) {
            student.display();
        } else {
            System.out.println("Student not found.");
        }
    }

    // Find Student
    static Student findStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    // Add Teacher
    static void addTeacher() {

        System.out.println("\n========== ADD TEACHER ==========");

        int id = readInt("Enter Teacher ID: ");

        System.out.print("Enter Teacher Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Subject: ");
        String subject = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        Teacher teacher = new Teacher(
                id,
                name,
                subject,
                phone
        );

        teachers.add(teacher);

        System.out.println("\nTeacher added successfully!");
    }

    // View Teachers
    static void viewTeachers() {

        System.out.println("\n========== TEACHER LIST ==========");

        if (teachers.isEmpty()) {
            System.out.println("No teachers available.");
            return;
        }

        for (Teacher teacher : teachers) {
            teacher.display();
        }
    }

    // Update Attendance
    static void updateAttendance() {

        System.out.println("\n========== UPDATE ATTENDANCE ==========");

        int id = readInt("Enter Student ID: ");

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        double attendance;

        do {
            attendance = readDouble(
                    "Enter Attendance Percentage (0-100): "
            );

            if (attendance < 0 || attendance > 100) {
                System.out.println(
                        "Please enter a value between 0 and 100."
                );
            }

        } while (attendance < 0 || attendance > 100);

        student.setAttendance(attendance);

        System.out.println("Attendance updated successfully!");

        if (attendance < 75) {
            System.out.println(
                    "WARNING: Student has low attendance!"
            );
        }
    }

    // Update Marks
    static void updateMarks() {

        System.out.println("\n========== UPDATE MARKS ==========");

        int id = readInt("Enter Student ID: ");

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        double marks;

        do {
            marks = readDouble(
                    "Enter Average Marks (0-100): "
            );

            if (marks < 0 || marks > 100) {
                System.out.println(
                        "Please enter marks between 0 and 100."
                );
            }

        } while (marks < 0 || marks > 100);

        student.setAverageMarks(marks);

        String grade =
                PerformanceAnalyzer.calculateGrade(marks);

        System.out.println(
                "Marks updated successfully!"
        );

        System.out.println("Grade: " + grade);
    }

    // Performance Analysis
    static void performanceAnalysis() {

        System.out.println("\n========== PERFORMANCE ANALYSIS ==========");

        int id = readInt("Enter Student ID: ");

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        double marks = student.getAverageMarks();
        double attendance = student.getAttendance();

        String grade =
                PerformanceAnalyzer.calculateGrade(marks);

        String result =
                PerformanceAnalyzer.analyze(
                        marks,
                        attendance
                );

        System.out.println("\nStudent Name : " + student.getName());
        System.out.println("Marks        : " + marks);
        System.out.println("Grade        : " + grade);
        System.out.println("Attendance   : " + attendance + "%");
        System.out.println("Analysis     : " + result);

        if (attendance < 75) {
            System.out.println(
                    "⚠ Warning: Improve attendance."
            );
        }

        if (marks < 50) {
            System.out.println(
                    "⚠ Warning: Academic support required."
            );
        }
    }

    // School Statistics
    static void showStatistics() {

        System.out.println("\n========== SCHOOL STATISTICS ==========");

        System.out.println(
                "Total Students : " + students.size()
        );

        System.out.println(
                "Total Teachers : " + teachers.size()
        );

        if (students.isEmpty()) {
            System.out.println(
                    "No student data available."
            );
            return;
        }

        int excellent = 0;
        int lowAttendance = 0;

        for (Student student : students) {

            if (student.getAverageMarks() >= 85 &&
                    student.getAttendance() >= 90) {
                excellent++;
            }

            if (student.getAttendance() < 75) {
                lowAttendance++;
            }
        }

        System.out.println(
                "Excellent Students : " + excellent
        );

        System.out.println(
                "Low Attendance     : " + lowAttendance
        );
    }

    // Read Integer Safely
    static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                int value = Integer.parseInt(
                        scanner.nextLine()
                );

                return value;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );
            }
        }
    }

    // Read Double Safely
    static double readDouble(String message) {

        while (true) {

            try {

                System.out.print(message);

                double value = Double.parseDouble(
                        scanner.nextLine()
                );

                return value;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a valid number."
                );
            }
        }
    }
}