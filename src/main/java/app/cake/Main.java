package app.cake;

public class Main {
    public static void main(String[] args) {
        MoonCake five = MoonCakeFactory.makeMoonCake("five");
        MoonCake egg = MoonCakeFactory.makeMoonCake("egg");

        five.description();
        egg.description();

        MoonCake five1 = MoonCakeFactory2.makeMoonCake(FiveNutsMoonCake.class);
        MoonCake egg1 = MoonCakeFactory2.makeMoonCake(EggYolkMoonCake.class);

        five1.description();
        egg1.description();
    }
}
