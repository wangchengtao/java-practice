package app;

public class A {
    {
        System.out.println("A block");
    }

    static {
        System.out.println("A static block");
    }

    public A() {
        System.out.println("A constructor");
    }
}
