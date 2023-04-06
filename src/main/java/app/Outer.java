package app;

public class Outer {
    private int a = 1;
    private static int b = 2;

    private static void test1() {
        System.out.println("Outer static test1 method.");
    }

    public void test() {
        // 外部类想方位内部类成员变量和方法, 需要先实例化内部类
        Inner inner = new Inner();
        System.out.println(inner.b);
        inner.test();

        // 外部类可直接通过 StaticInner.XXX 类访问内部类的静态资源
        // 外部类如果想访问内部类的成员变量和普通方法, 需实例化内部类
        System.out.println(StaticInner.c);
        StaticInner.test4();
        // StaticInner staticInner = new StaticInner();
        // System.out.println(staticInner.d);
        // staticInner.test();
    }

    class Inner {
        private String b = "Inner";

        private void test2() {
            System.out.println("Inner test2 method.");
        }

        // 内部类可直接访问外部类的属性和方法
        private void test() {
            System.out.println(a);
            test1();
        }
    }

    static class StaticInner {
        private static String c = "Static Inner";
        private int d = 10;

        public void test3() {
            System.out.println("Static Inner method test3");
        }

        private static void test4() {
            System.out.println("Static Inner static method test4");
        }

        public void test() {
            // 静态内部类可直接访问外部类静态属性和方法
            // 静态内部类如果想访问外部类普通属性和方法需实例化外部类
            System.out.println(b);
            test1();
            Outer outer = new Outer();
            outer.test();
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.test();
    }

}
