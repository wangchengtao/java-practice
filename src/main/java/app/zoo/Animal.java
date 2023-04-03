package app.zoo;

public abstract class Animal {
    public String name;

    public void speak() {
        System.out.println("我是动物");
    }

    public abstract void eat();
}
