package app;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class Person implements Cloneable, Serializable {
    private String name;
    private transient int age; // 不想序列化

    public Person() {
        this.name = "default";
        this.age = 0;
    }

    public Person(String name) {
        this(name, 18);
    }

    private Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void info() {
        System.out.println("My name is " + name + ", I'm " + age + " years old.");
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, CloneNotSupportedException, IOException {
        Person p1 = new Person("Jack", 30);
        p1.info();

        Person p2 = (Person)Class.forName("app.Person").newInstance();
        Person p3 = Person.class.newInstance();

        p2.info();
        p3.info();

        Person p4 = (Person)Class.forName("app.Person").getConstructor(String.class).newInstance("WDF");
        Person p5 = (Person)Class.forName("app.Person").getDeclaredConstructor(String.class, Integer.class).newInstance("项羽", 10);

        p4.info();
        p5.info();

        Person p6 = (Person) p1.clone();
        p6.info();

        File file = new File(System.getProperty("user.dir") + "/target/person.txt");
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(file));
        o.writeObject(p4);

        ObjectInputStream i = new ObjectInputStream(new FileInputStream(file));
        Person p7 = (Person) i.readObject();

        p7.info();
    }
}