package app;

import app.zoo.Cat;

import java.math.BigDecimal;
import java.util.Arrays;

public class Main {
    public static int i = 0;

    public static void main(String[] args) {
        add();
        System.out.println(i);

        Cat cat = new Cat("项羽");
        Cat newCat = (Cat) cat.clone();
        Cat simpleCat = cat;

        cat.name = "张三";
        simpleCat.name = "刘备";
        cat.meow();
        newCat.meow();
        simpleCat.meow();

        int a = 10_0000_000;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toHexString(a));
        System.out.println(Integer.toOctalString(a));

        System.out.println(0.1 + 0.2);
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(0.1f)));


        BigDecimal c = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.2");
        System.out.println(c.add(b));
        int[] arr = {1, 2, 3, 4, 5};
        setArr(arr);
        System.out.println(Arrays.toString(arr));

        short s = 3;
        int i = 2;
        double d = 1;
        double dob = s + i + d;
        System.out.println((double) i / s);

        int sd = 1;
        int f = 1;
        System.out.println(sd == f);

        Integer integer1 = 128;
        Integer integer2 = 128;
        System.out.println(integer1 == integer2);

        Cat cat1 = new Cat("曹操");
        Cat cat2 = new Cat("曹操");
        System.out.println(cat1.name == cat2.name);

    }

    public static void setArr(int[] arr) {
        Arrays.fill(arr, 1);
    }

    public static void add() {
        i++;
    }
}
