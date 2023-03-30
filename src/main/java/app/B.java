package app;

public class B extends A {
    {
        System.out.println("B block");
    }

    static {
        System.out.println("B static block");
    }

    public B() {
        System.out.println("B constructor");
    }

    public static void main(String[] args) {
        new B();
    }
}