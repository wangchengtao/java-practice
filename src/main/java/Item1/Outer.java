package Item1;

public class Outer {
    private int a = 1;

    private static int b = 2;

    public void test1() {
        System.out.println("Outer test1 method.");
    }

    public int getA() {
        return a;
    }

    public static void test2() {
        System.out.println("Outer static method.");
    }

    class Inner {
        private String b = "inner";

        public void test2() {
            System.out.println("Inner test2 method");
        }

        public void test() {
            System.out.println(a);
            test1();
        }
    }

    static class Inner2 {
        private String c = "static";
        private static String d = "d";

        public void test1() {
            System.out.println("Inner method");
        }

        public static void test2() {
            System.out.println("Inner static method");
        }

        public void test() {
            // 静态内部类可以访问外部类的所有静态成员和方法
            // 静态内部类如果想访问外部类的普通成员和普通方法, 需要先实例化外部类
            Outer outer = new Outer();
            System.out.println(outer.getA());
            outer.test1();
            Outer.test2();
            System.out.println(Inner2.d);
        }
    }

    public void test() {
        Inner inner = new Inner();
        System.out.println(inner.b);
        inner.test();

        Inner2 inner2 = new Inner2();
        inner2.test();
    }
}
