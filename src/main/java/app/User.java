package app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class User {
    private final Integer id;
    private final String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // 过滤ID为偶数的用户
    public static List<User> filterUsersWithEvenId(List<User> users) {
        return filter(users, user -> user.id % 2 == 0);
    }

    // 过滤姓张的用户
    public static List<User> filterZhangUsers(List<User> users) {
        return filter(users, user -> user.name.startsWith("张"));
    }

    // 过滤姓王的用户
    public static List<User> filterWangUsers(List<User> users) {
        return filter(users, new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.name.startsWith("王");
            }
        });
    }

    // 通过Predicate接口将上述代码抽取成一个公用的过滤器函数
    private static List<User> filter(List<User> users, Predicate<User> predicate) {
        List<User> list = new ArrayList<>();

        for (User user : users) {
            if (predicate.test(user)) {
                list.add(user);
            }
        }

        return list;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "张三"));
        users.add(new User(7, "张四"));
        users.add(new User(4, "王五"));
        users.add(new User(6, "李四"));
        users.add(new User(11, "王二"));
        users.add(new User(10, "李逵"));

        System.out.println(users);
        System.out.println(User.filterUsersWithEvenId(users));
        System.out.println(User.filterWangUsers(users));
        System.out.println(User.filterZhangUsers(users));
    }
}
