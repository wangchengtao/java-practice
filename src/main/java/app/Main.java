package app;

import app.zoo.Cat;

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

        int[] arr = {1, 2, 3, 4, 5};
        setArr(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void setArr(int[] arr) {
        Arrays.fill(arr, 1);
    }

    public static void add() {
        i++;
    }
}
