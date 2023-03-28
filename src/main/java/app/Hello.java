package app;

import Item1.*;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class Hello {
    public static void main(String[] args) throws IOException {
        int[] a = {2, 4, 6, 7, 8};
        System.out.println(Arrays.toString(a));
        swap(a, 3,4);
        System.out.println(Arrays.toString(a));

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        for (String s : list) {
            System.out.println("s = " + s);
        }


        Person wct = new Person("wangchengtao", 28, 135, 170);
        wct.info();
        wct.eat();
        wct.sleep();

        String s = "h";
        String ss = "h";
        System.out.println(s.equals(ss) ? "shallow copy" : "deep copy");

        MoonCake five = MoonCakeFactory.makeMoonCake("Five");
        MoonCake bean = MoonCakeFactory.makeMoonCake("Bean");

        five.description();
        bean.description();

        //use reflect
        MoonCake fiveNutsMoonCake2 = MoonCakeFactory2.makeMoonCake(FiveNutsMoonCake.class);
        MoonCake beanSandMoonCake2 =  MoonCakeFactory2.makeMoonCake(BeanSandMoonCake.class);
        MoonCake eggYolkMoonCake =  MoonCakeFactory2.makeMoonCake(EggYolkMoonCake.class);

        fiveNutsMoonCake2.description();
        beanSandMoonCake2.description();
        eggYolkMoonCake.description();

        CharDisplay ch = new CharDisplay('H');
        ch.display();
        StringDisplay sd = new StringDisplay("Dobby");
        sd.display();

        Animal animal = new Cat();
        System.out.println(animal.name);
        animal.eat();
        animal.speak();
        ((Cat) animal).catchMouse();

        if (animal instanceof Cat) {
            // 向下转型
            Cat cat = (Cat)animal;
            cat.catchMouse();
        } else if (animal instanceof Dog) {
            Dog dog = (Dog)animal;
            dog.watchHouse();
        }


        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        if (singleton1.equals(singleton2)) {
            System.out.println("是同一个实例");
        }

        CountingSet countingSet = new CountingSet();
        countingSet.add(new Object());
        countingSet.addAll(Arrays.asList(1, 2, 3));
        countingSet.remove(new Object());
        System.out.println(countingSet.getCount());

        Base obj = new Sub();
        ParamBase param = new ParamSub();
        obj.print(param);

        Path projectDir = Paths.get(System.getProperty("user.dir"));
        Path testRootDir = projectDir.resolve("src/main/java/app");

        if (!testRootDir.toFile().isDirectory()) {
            throw new IllegalStateException(testRootDir.toAbsolutePath().toString() + "不存在");
        }

        List<String> filterFileNames = filter(testRootDir, "java");
        System.out.println(filterFileNames);


        Integer[] arr = new Integer[]{3, 4, 21, 8, 7, 9, 1};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, Collections.<Integer>reverseOrder());
        System.out.println(Arrays.toString(arr));;

        Student s1 = new Student(3, "Jack");
        Student s2 = new Student(7, "Rose");
        Student s3 = new Student(10, "Bob");
        Student s4 = new Student(2, "Sten");
        Student[] students = new Student[]{s1, s2, s3, s4};

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

        // 升序排序
        Arrays.sort(students, Comparator.comparingInt(o -> o.id));
        System.out.println(Arrays.toString(students));
        // 降序排序
        Arrays.sort(students, (o1, o2) -> o2.id - o1.id);

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId() - o2.getId();
            }
        });
        System.out.println(Arrays.toString(students));

        Outer outer = new Outer();
        outer.test();
        outer.test1();

        User user1 = new User(1, "张涛");
        User user2 = new User(3, "王二");
        User user3 = new User(6, "三不沾");
        User user4 = new User(7, "李四");
        User user5 = new User(22, "张家水");
        User user6 = new User(10, "张三");
        List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6);
        System.out.println(users);
        System.out.println(User.filterUsersNameWang(users));
        System.out.println(User.filterUsersNameZhang(users));
        System.out.println(User.filterUsersWithEvenId(users));

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("do something");
            }
        };

        Thread t = new Thread(runnable);
        t.start();

        System.out.println("Args size: " + args.length);
       // System.out.println("first args: " + args[0]);
       // System.out.println("second args: " + args[1]);


        Set<Integer> linkedHashSet = new HashSet<>();
        linkedHashSet.add(1);
        linkedHashSet.add(3);
        linkedHashSet.add(20);
        linkedHashSet.add(4);

        for (Integer integer : linkedHashSet) {
            System.out.println(integer);
        }

        Map<String, String> map = new HashMap<>();
        map.put("name", "Jack");
        map.put("gender", "male");

        Map<String, String> map1 = new HashMap<>(){{
           put("name", "Lucy");
           put("gender", "female");
        }};

        Map<String, String> map2 = Map.of(
                "name", "Jack",
                "gender", "male"
        );

        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key: " + entry.getKey() + ", " + "value: " + entry.getValue());
        }

        for(String key : map1.keySet()) {
            System.out.println("key: " + key);
        }

        for(String value : map1.values()) {
            System.out.println("value: " + value);
        }

        Map<Integer, String> map3 = new HashMap<>();
        map3.put(1, "Jack");
        map3.put(2, "Rose");
        map3.put(3, "Tom");
        map3.put(4, "Jerry");

        for(Map.Entry<Integer, String> entry : map3.entrySet()) {
            System.out.println("key: " + entry.getKey() + "value: " + entry.getValue());
        }

        for(Integer i : map3.keySet()) {
            System.out.println(i);
        }

        for(String i : map3.values()) {
            System.out.println(i);
        }

        Iterator<Map.Entry<Integer, String>> array = map3.entrySet().iterator();
        while(array.hasNext()) {
            Map.Entry<Integer, String> entry = array.next();
            System.out.println(entry.getKey() + entry.getValue());
        }

        List<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(4);
        list1.add(3);
        list1.add(6);
        list1.add(1);
        list1.add(0);
        Collections.sort(list1);
        System.out.println(list1);

        List<Object> list2 = Collections.emptyList();
        Set<Object> list3 = Collections.emptySet();
        Map<Object, Object> list4 = Collections.emptyMap();
        SortedSet<Object> list5 = Collections.emptySortedSet();
        SortedMap<Object, Object> list6 = Collections.emptySortedMap();
        // 把一个集合变成线程安全集合
        Collection<Object> synchronizedCollection = Collections.synchronizedCollection(list2);


        Collection<Integer> unmodifiedList = Collections.unmodifiableCollection(list1);
        list1.add(10);
        System.out.println(unmodifiedList);

        File projectDir1 = new File(System.getProperty("basedir"), System.getProperty("user.dir"));
        File testFile = new File(projectDir1, "target/test.txt");
        List<String> lines = Arrays.asList("AAA", "BBB", "CCC中");

        writeLinesToFile4(lines, testFile);
        System.out.println(readFile4(testFile));

        writeLinesToFile1(testFile);
        System.out.println(readFile1(testFile));

        List<String> lines1 = new ArrayList<>();
        lines1.add("诸葛村夫");

        writeLinesToFile2(lines1, testFile);
        System.out.println(readFile2(testFile));

        writeLinesToFile3(lines1, testFile);
        System.out.println(readFile3(testFile));

        if (isValid("{}()[]]")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        Integer[] ints = new Integer[]{3, 2, 4, 5};
        DynamicArray<Integer> dynamicArray = new DynamicArray<>(ints);
        System.out.println(dynamicArray.toString());

        int opCount = 10000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue time : " + time1 + " s");
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue time : " + time2 + " s");
    }

    public static double testQueue(Queue<Integer> queue, int opCount) {
        long startTime = System.nanoTime();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(i);
        }
        // System.out.println(queue);
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (ArrayUtils.contains(new char[]{'{', '(', '['}, c)) {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    char p = stack.pop();
                    if (p != '{' && c == '}') return false;
                    if (p != '(' && c == ')') return false;
                    if (p != '[' && c == ']') return false;
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static List<String> readFile3(File file) {
        try {
            return Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void writeLinesToFile3(List<String> lines, File file) {
        try {
            Files.write(file.toPath(), lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFile2(File file) {
        try {
            return IOUtils.readLines(new FileInputStream(file), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void writeLinesToFile2(List<String> lines, File file) {
        try {
            IOUtils.writeLines(lines, "\n", new FileOutputStream(file), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFile1(File file) {
        List<String> list = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;

            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void writeLinesToFile1(File file) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))) {
            // 文件流可自动关闭 不需要手动 close

            Properties properties = System.getProperties();
            for (Map.Entry<Object, Object> objectObjectEntry : properties.entrySet()) {
                bw.write( objectObjectEntry.toString() + "\n");
            }

            // bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static List<String> readFile4(File file) {
        List<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();

        try {
            InputStream is = new FileInputStream(file);
            int content;

            while ((content = is.read()) != -1) {
                // \n ----> 10
                if (content == 10) {
                    list.add(sb.toString());
                    sb = new StringBuffer();
                } else {
                    sb.append((char) content);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void writeLinesToFile4(List<String> lines, File file) {
        try {
            OutputStream os = new FileOutputStream(file);

            for (String line : lines) {
                os.write(line.getBytes());
                os.write("\n".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<String> filter(Path dir, final String ext) throws IOException {
        final List<String> res = new ArrayList<>();


        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                System.out.println("Visit file" + file);

                if (file.toString().endsWith(ext)) {
                    res.add(file.getFileName().toString());
                }

                return FileVisitResult.CONTINUE;
            }
        });

        return res;
    }

    public static void swap(int[] a, int i, int j) {
        if (i == j || a[i] == a[j]) {
            return;
        }

        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }
}
