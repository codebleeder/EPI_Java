package Chapter13_Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting_00_SortByName {
    public static void sortByName(List<Student> students){
        Collections.sort(students);
    }
    public static void sortByGPA(List<Student> students){
        Comparator<Student> gpaComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.gpa, o2.gpa);
            }
        };
        Collections.sort(students, Collections.reverseOrder(gpaComparator));
    }
    public static void test(){
        List<Student> students = Arrays.asList(
                new Student("a", 3.3),
                new Student("b", 3.2),
                new Student("z", 3.1),
                new Student("j", 2.9)
        );
        System.out.println("sort by name");
        sortByName(students);
        printStudents(students);

        System.out.println();
        System.out.println("sort by gpa");
        sortByGPA(students);
        printStudents(students);
    }
    public static void printStudents(List<Student> students){
        for (Student s: students)
        {
            System.out.println(s.toString());
        }
    }
}

class Student implements Comparable<Student> {
    public String name;
    public double gpa;
    Student(String name, double gpa){
        this.name = name;
        this.gpa = gpa;
    }
    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.name);
    }

    public String toString(){
        return "name: " + name + " " + "GPA: " + String.valueOf(gpa);
    }
}
