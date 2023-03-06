package Item1;


import java.util.Arrays;
import java.util.Comparator;

public class Student implements Comparable<Student> {
    public int id;
    public String name;

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
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo( Student o) {
        return getId() - o.getId();
    }

    // 按照学生id由小到小大
    public static class IdAscendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    // 按照学生id由大到小
    public static class IdDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(3, "Jack");
        Student s2 = new Student(7, "Rose");
        Student s3 = new Student(1, "Jerry");
        Student s4 = new Student(9, "Tom");
        Student[] students = {s1, s2, s3, s4};

        // 升序排序
        Arrays.sort(students, new IdAscendingComparator());
        System.out.println(Arrays.toString(students));
        // 降序排序
        Arrays.sort(students, new IdDescendingComparator());
        System.out.println(Arrays.toString(students));
    }
}
