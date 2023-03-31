package app.cake;

public class MoonCakeFactory {
    public static MoonCake makeMoonCake(String type) {
        return switch (type) {
            case "five" -> new FiveNutsMoonCake();
            case "egg" -> new EggYolkMoonCake();
            case "bean" -> new BeanSandMoonCake();
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }
}
