package app;

class Cat extends Animal {
    private String name = "猫";
    private String color;
    private int age;
    private boolean cute;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isCute() {
        return cute;
    }

    public void setCute(boolean cute) {
        this.cute = cute;
    }

    public void miao() {
        System.out.println("喵~");
    }

    @Override
    public void eat() {
        System.out.println(name);
    }

    public void speak() {
        System.out.println("我是一只猫");
    }

    public void catchMouse() {
        System.out.println("抓老鼠");
    }
}
