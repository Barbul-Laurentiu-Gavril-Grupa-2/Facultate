package isp.lab6.exercise1;

import java.util.ArrayList;
import java.util.List;

public class GradeManagementSystem {
    List<Student> students;

    public GradeManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void updateStudent(Student student, String name, int id) {
        student.setName(name);
        student.setId(id);
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + student.getId());
            System.out.println("Grades: " + student.getGrades());
            System.out.println("Average Grade: " + student.calculateAverageGrade());
            System.out.println();
        }
    }
}
