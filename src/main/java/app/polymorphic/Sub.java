package app.polymorphic;

public class Sub extends Base {
    public void print(ParamBase param) {
        System.out.println("I am sub, the param is ParamBase.");
    }

    public void print(ParamSub param) {
        System.out.println("I am sub, the param is ParamSub.");
    }
}
