package app;

public class Person {
    private final String name;
    private final int age;
    private int weight;
    private int height;

    public Person(String name, int age, int weight, int height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public void eat() {
        System.out.println("I can eat\n");
    }

    public void sleep() {
        System.out.println("I can sleep\n");
    }

    public void info() {
        height++;
        weight++;
        System.out.printf("姓名: %s 年龄: %d 体重: %d 身高: %d\n", name, age, weight, height);
    }
}