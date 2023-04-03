package app.zoo;

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
    }
}
