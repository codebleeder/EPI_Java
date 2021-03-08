package Chapter12_HashTables;

import java.util.*;

public class HashTables_11_FindStudentWithHighestAvg {
    private static class Student implements Comparable<Student> {
        public String name;
        public Integer score;

        public Student(String name, Integer score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return this.score.compareTo(o.score);
        }

        @Override
        public String toString() {
            return String.format("name: %s, score: %d", name, score);
        }
    }

    private static Student findStudentWithHighestAvg(Iterator<Student> iterator) {
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        Comparator<Integer> comparator = (Integer s1, Integer s2) -> s1.compareTo(s2);

        while (iterator.hasNext()) {
            Student student = iterator.next();
            PriorityQueue<Integer> pq;
            if (map.containsKey(student.name)) {
                pq = map.get(student.name);
                if (pq.size() >= 3 && pq.peek() < student.score) {
                    pq.poll();
                    pq.add(student.score);
                } else if (pq.size() < 3) {
                    pq.add(student.score);
                }
            } else {
                pq = new PriorityQueue<>(3, comparator);
                pq.add(student.score);

            }

            map.put(student.name, pq);
        }

        // iterate to calculate avg and student with highest avg
        Student result = new Student("", Integer.MIN_VALUE);

        for (Map.Entry<String, PriorityQueue<Integer>> entry : map.entrySet()) {
            int total = 0;
            while (!entry.getValue().isEmpty()) {
                total += entry.getValue().poll();
            }
            int avg = total / 3;
            if (avg > result.score) {
                result.name = entry.getKey();
                result.score = avg;
            }
        }

        return result;
    }

    // book solution:

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("a", 70),
                new Student("a", 71),
                new Student("a", 72),
                new Student("a", 73),

                new Student("b", 82),
                new Student("b", 81),
                new Student("b", 83),
                new Student("b", 80),

                new Student("c", 90),
                new Student("c", 91),
                new Student("c", 92),
                new Student("c", 93)
        ));

        Student result = findStudentWithHighestAvg(students.iterator());
        System.out.println(result.toString());

    }
}
