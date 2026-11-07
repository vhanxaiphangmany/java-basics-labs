import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    // Store student information
    static ArrayList<Student> students = new ArrayList<>();

    // Student class
    static class Student {
        String name;
        int age;
        String studentClass;
        String institution;
        String phone;
        String studentID;

        Student(String name, int age, String studentClass,
                String institution, String phone, String studentID) {
            this.name = name;
            this.age = age;
            this.studentClass = studentClass;
            this.institution = institution;
            this.phone = phone;
            this.studentID = studentID;
        }

        void displayInfo() {
            System.out.println("\n===== Student Info =====");
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Class: " + studentClass);
            System.out.println("Institution: " + institution);
            System.out.println("Phone: " + phone);
            System.out.println("Student ID: " + studentID);
            System.out.println("========================");
        }
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Edit Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose menu: ");

            try {
                choice = Integer.parseInt(input.nextLine());

                switch (choice) {
                    case 1:
                        addStudent();
                        break;

                    case 2:
                        viewStudents();
                        break;

                    case 3:
                        editStudent();
                        break;

                    case 4:
                        deleteStudent();
                        break;

                    case 5:
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("Invalid choice! Please choose 1-5.");
                }


            } catch (NumberFormatException e) {
                choice = 0;
                System.out.println("Please enter a valid number!");
            }

        } while (choice != 5);

        input.close();
    }

    // Add student
    static void addStudent() {

        System.out.println("\n===== Add Student =====");

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        int age;

        while (true) {
            System.out.print("Enter your age: ");

            try {
                age = Integer.parseInt(input.nextLine());

                if (age <= 0) {
                    System.out.println("Age must be greater than 0!");
                    continue;
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid age!");
            }
        }

        System.out.print("Enter your class: ");
        String studentClass = input.nextLine();

        System.out.print("Enter your institution: ");
        String institution = input.nextLine();

        System.out.print("Enter your phone number: ");
        String phone = input.nextLine();

        System.out.print("Enter your student ID: ");
        String studentID = input.nextLine();

        // Check duplicate student ID
        if (findStudent(studentID) != null) {
            System.out.println("Student ID already exists!");
            return;
        }

        Student student = new Student(
                name, age, studentClass,
                institution, phone, studentID
        );

        students.add(student);

        System.out.println("Student added successfully!");
    }

    // View all students
    static void viewStudents() {

        System.out.println("\n===== Student List =====");

        if (students.isEmpty()) {
            System.out.println("No student information found.");
            return;
        }

        for (Student student : students) {
            student.displayInfo();
        }
    }

    // Edit student
    static void editStudent() {

        System.out.println("\n===== Edit Student =====");

        System.out.print("Enter Student ID to edit: ");
        String studentID = input.nextLine();

        Student student = findStudent(studentID);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("Leave a field empty to keep its current value.");

        System.out.print("Enter new name [" + student.name + "]: ");
        String name = input.nextLine();

        if (!name.isEmpty()) {
            student.name = name;
        }

        while (true) {
            System.out.print("Enter new age [" + student.age + "]: ");
            String ageInput = input.nextLine();

            if (ageInput.isEmpty()) {
                break;
            }

            try {
                int age = Integer.parseInt(ageInput);

                if (age <= 0) {
                    System.out.println("Age must be greater than 0!");
                    continue;
                }

                student.age = age;
                break;

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid age!");
            }
        }

        System.out.print("Enter new class [" + student.studentClass + "]: ");
        String studentClass = input.nextLine();

        if (!studentClass.isEmpty()) {
            student.studentClass = studentClass;
        }

        System.out.print("Enter new institution [" + student.institution + "]: ");
        String institution = input.nextLine();

        if (!institution.isEmpty()) {
            student.institution = institution;
        }

        System.out.print("Enter new phone [" + student.phone + "]: ");
        String phone = input.nextLine();

        if (!phone.isEmpty()) {
            student.phone = phone;
        }

        System.out.println("Student information updated successfully!");
    }

    // Delete student
    static void deleteStudent() {

        System.out.println("\n===== Delete Student =====");

        System.out.print("Enter Student ID to delete: ");
        String studentID = input.nextLine();

        Student student = findStudent(studentID);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        student.displayInfo();

        System.out.print("Are you sure you want to delete? (Y/N): ");
        String confirm = input.nextLine();

        if (confirm.equalsIgnoreCase("Y")) {
            students.remove(student);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Delete cancelled.");
        }
    }

    // Find student by ID
    static Student findStudent(String studentID) {

        for (Student student : students) {
            if (student.studentID.equalsIgnoreCase(studentID)) {
                return student;
            }
        }

        return null;
    }
}