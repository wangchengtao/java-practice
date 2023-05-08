package app;

import app.zoo.Animal;
import app.zoo.Cat;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int j = 0;
        int i = 0;
        i = i++ + ++i; // 0 + 2
        j = ++j + j++ + j++ + j++;  // 1 + 1 + 2 + 3
        System.out.println(i); // 2
        System.out.println(j); // 7

        MyTestClass myTestClass = MyTestClass.getInstance();
        System.out.println("a: " + myTestClass.getA()); // 0
        System.out.println("b: " + myTestClass.getB()); // 1

        Animal cat = new Cat();
        cat.speak();

        threadRun();
        outputSystemProperties();

    }

    public static void threadRun() {
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

    public static void outputSystemProperties() {
        File file = new File(System.getProperty("user.dir") + "/target/properties.txt");

        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));

            for (Map.Entry<Object, Object> line : System.getProperties().entrySet()) {
                bw.write(line.toString() + "\n");
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
