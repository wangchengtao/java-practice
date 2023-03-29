package app.zoo;

public class Cat extends Animal implements Cloneable {
    public String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println("喵喵喵~~~" + name);
    }

    @Override
    public Object clone() {
        Cat cat = null;
        try {
            cat = (Cat) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return cat;
    }
}
