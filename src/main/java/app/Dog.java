package app;

public class Dog extends Animal {
    public void wang() {
        System.out.println("汪~");
    }

    @Override
    public void eat() {
        System.out.println("吃屎");
    }

    public void watchHouse() {
        System.out.println("看家");
    }
}
