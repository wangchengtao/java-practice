package Item1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class User {
    private static List<User> users;
    private static Predicate<User> predicate;

    private final int Id;
    private final String name;

    public User(int id, String name) {
        this.Id = id;
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }

    // 过滤ID为偶数的用户
    public static List<User> filterUsersWithEvenId(List<User> users) {
        return filter(users, user -> user.Id % 2 == 0);
    }

    // 过滤姓张的用户
    public static List<User> filterUsersNameZhang(List<User> users) {
        return filter(users, user -> user.name.startsWith("张"));
    }

    // 过滤姓王的用户
    public static List<User> filterUsersNameWang(List<User> users) {
        return filter(users, new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.name.startsWith("王");
            }
        });
    }

    // 通过Predicate接口将上述代码抽取成一个公用的过滤器函数
    public static List<User> filter(List<User> users, Predicate<User> predicate) {
        List<User> result = new ArrayList<>();

        for (User user: users) {
            if (predicate.test(user)) {
                result.add(user);
            }
        }

        return result;
    }

}
