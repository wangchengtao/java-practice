package app;

import app.zoo.Animal;
import app.zoo.Cat;

public class Main {
    public static void main(String[] args) {
        int j = 0;
        int i = 0;
        i = i++ + ++i;
        j = ++j + j++ + j++ + j++;
        System.out.println(i); // 1
        System.out.println(j); // 4

        MyTestClass myTestClass = MyTestClass.getInstance();
        System.out.println("a: " + myTestClass.getA());
        System.out.println("b: " + myTestClass.getB());

        Animal cat = new Cat();
        cat.speak();

        Runnable runnable = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("do sth");
        };

        Thread t = new Thread(runnable);
        t.start();
    }

}
