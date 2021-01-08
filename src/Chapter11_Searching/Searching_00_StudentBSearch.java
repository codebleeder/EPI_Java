package Chapter11_Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Searching_00_StudentBSearch {
    private static class Student implements Comparable<Student> {
        public String name;
        public Double gpa;

        public Student(String name, Double gpa) {
            this.name = name;
            this.gpa = gpa;
        }

        @Override
        public int compareTo(Student o) {
            if (gpa != o.gpa) {
                return gpa.compareTo(o.gpa);
            }
            return name.compareTo(o.name);
        }
    }

    public static boolean searchStudent(List<Student> students, Student target) {
        return Collections.binarySearch(students, target) >= 0;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(
                Arrays.asList(
                        new Student("sharad", 3.5),
                        new Student("surabhi", 3.5),
                        new Student("ramesh", 4.0),
                        new Student("anjana", 3.2)
                )
        );

        System.out.println(searchStudent(students, new Student("surabhi", 3.5)));
        System.out.println(searchStudent(students, new Student("ramesh", 3.2)));
    }
}
