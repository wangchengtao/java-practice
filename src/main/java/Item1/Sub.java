package Item1;

public class Sub extends Base {
    @Override
    public void print(ParamBase paramBase) {
        System.out.println("I am Sub, the param is ParamBase");
    }

    @Override
    public void print(ParamSub paramSub) {
        System.out.println("I am Sub, the param is ParamSub");
    }
}
