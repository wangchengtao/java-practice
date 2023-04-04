package app;

import java.util.Arrays;
import java.util.Comparator;

public class Student implements Comparable<Student> {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name=" + name + "}";
    }

    @Override
    public int compareTo(Student o) {
        return this.id - o.id;
    }

    public static class IdAscendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    public static class IdDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(3, "Jack");
        Student s2 = new Student(21, "Tony");
        Student s3 = new Student(13, "Lucy");
        Student s4 = new Student(34, "Tom");
        Student[] students = {s1, s2, s3, s4};

        Arrays.sort(students, (o1, o2) -> o2.id - o1.id);
        System.out.println(Arrays.toString(students));

        Arrays.sort(students, new IdAscendingComparator());
        System.out.println(Arrays.toString(students));

        Arrays.sort(students, new IdDescendingComparator());
        System.out.println(Arrays.toString(students));

        Arrays.sort(students, Comparator.comparingInt(o -> o.id));
        System.out.println(Arrays.toString(students));
    }
}
