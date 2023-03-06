package Item1;


public class MoonCakeFactory2 {
    public static <T extends MoonCake> T makeMoonCake(Class<T> klass) {
        MoonCake moonCake = null;
        try {
            moonCake = (MoonCake)Class.forName(klass.getName()).getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return (T)moonCake;
    }
}