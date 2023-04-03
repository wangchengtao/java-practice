package app.polymorphic;

public class Base {
    public void print(ParamBase param) {
        System.out.println("I am base, the param is ParamBase.");
    }

    public void print(ParamSub param) {
        System.out.println("I am base, the param is ParamSub.");
    }
}
