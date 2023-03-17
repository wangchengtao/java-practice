package Item1;

public class Singleton {
    private static final Singleton singleton = new Singleton();

    // 构造器私有化，无法使用 new 来生成实例
    private Singleton() {
    }

    // 静态工厂方法，返回独有的实例
    public static Singleton getInstance() {
        return singleton;
    }
}