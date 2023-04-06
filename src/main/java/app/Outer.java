package app;

public class Outer {
    private int a = 1;

    public void test1() {
        System.out.println("Outer test1 method.");
    }

    // 外部类想方位内部类成员变量和方法, 需要先实例化内部类
    public void test() {
        Inner inner = new Inner();
        System.out.println(inner.b);
        inner.test();
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


    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.test();
    }

}
