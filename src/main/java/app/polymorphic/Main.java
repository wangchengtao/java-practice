package app.polymorphic;

public class Main {
    public static void main(String[] args) {
        Base obj = new Sub();
        ParamBase param = new ParamSub();
        obj.print(param);
    }
}
