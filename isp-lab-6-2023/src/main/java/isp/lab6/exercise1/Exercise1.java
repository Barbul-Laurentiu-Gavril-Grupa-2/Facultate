package isp.lab6.exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        // Create GradeManagementSystem object
        GradeManagementSystem system = new GradeManagementSystem();

        // Create and add students to the system
        Student student1 = new Student("John Doe", 1001);
        student1.addGrade("Math", 90);
        student1.addGrade("Science", 85);
        system.addStudent(student1);

        Student student2 = new Student("Jane Smith", 1002);
        student2.addGrade("Math", 95);
        student2.addGrade("Science", 92);
        system.addStudent(student2);

        // Display the list of students
        System.out.println("List of Students:");
        system.displayStudents();

        // Update a student's information
        Student studentToUpdate = system.students.get(0);
        system.updateStudent(studentToUpdate, "John Johnson", 1003);

        // Remove a student from the system
        Student studentToRemove = system.students.get(1);
        system.removeStudent(studentToRemove);

        // Display the updated list of students
        System.out.println("Updated List of Students:");
        system.displayStudents();
    }
}
