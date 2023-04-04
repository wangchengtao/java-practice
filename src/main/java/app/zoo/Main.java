package app.zoo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.eat();
        animal.speak();
        System.out.println(animal.name);

        Cat cat = (Cat)animal;
        cat.speak();

        // Dog dog = (Dog) animal;
        // dog.watchHouse();
        Integer[] arr = new Integer[]{1, 2, 4, 9, 0};

        Arrays.sort(arr, (o1, o2) -> o2 - o1);
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
    }
}
