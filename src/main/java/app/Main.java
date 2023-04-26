package app;

import app.zoo.Animal;
import app.zoo.Cat;
import org.apache.commons.io.output.WriterOutputStream;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        int j = 0;
        int i = 0;
        i = i++ + ++i;
        j = ++j + j++ + j++ + j++;
        System.out.println(i); // 1
        System.out.println(j); // 4

        MyTestClass myTestClass = MyTestClass.getInstance();
        System.out.println("a: " + myTestClass.getA());
        System.out.println("b: " + myTestClass.getB());

        Animal cat = new Cat();
        cat.speak();

        Runnable runnable = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("do sth");
        };

        Thread t = new Thread(runnable);
        t.start();

        System.out.println(System.getenv("AAA"));
        System.out.print("水电费");
        System.err.println("standard error");
        System.out.println("Main.main");
        System.out.println("args = " + Arrays.deepToString(args));
        System.out.println("t = " + t);

        File file = new File(System.getProperty("user.dir") + "/target/properties.txt");

        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));

            for (Map.Entry<Object, Object> line : System.getProperties().entrySet()) {
                bw.write(line.toString() + "\n");
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ProcessBuilder pb = new ProcessBuilder("sh", "run.sh");

        pb.redirectOutput(getOutputFile());
        pb.directory(getWorkingDir());
        Map<String, String> environment = pb.environment();
        environment.put("AAA", "123");
        try {
            pb.start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

    }

    private static File getOutputFile() {
        return new File(getWorkingDir(), "output.txt");
    }

    private static File getWorkingDir() {
        Path dir = Paths.get(System.getProperty("user.dir"));
        return dir.resolve("target").toFile();
    }

}
