package Item1;

public class MoonCakeFactory {
    public static MoonCake makeMoonCake(String type) {
        MoonCake cake;

        switch (type) {
            case "Five":
                cake = new FiveNutsMoonCake();
                break;
            case "Egg":
                cake = new EggYolkMoonCake();
                break;
            case "Bean":
            default:
                cake = new BeanSandMoonCake();
                break;
        }

        return cake;
    }
}
