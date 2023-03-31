package app.cake;

public class MoonCakeFactory2 {
    public static <T extends MoonCake> T makeMoonCake(Class<T> tClass) {
        T cake = null;
        try {
            cake = tClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cake;
    }
}
