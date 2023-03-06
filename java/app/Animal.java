package app;

public abstract class Animal {
    protected String name = "animal";

    public abstract void eat();

    public void speak() {
        System.out.println("我是一个动物");
    }

    public String getName() {
        return name;
    }
}
