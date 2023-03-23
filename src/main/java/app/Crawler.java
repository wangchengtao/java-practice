package app;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;


public class Crawler {
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir") + "/target/test1.txt");

        saveArticleToFile("java", file);
    }

    public static void saveArticleToFile(String repo, File file) {
        OkHttpClient httpClient = new OkHttpClient.Builder().build();
        String url = "https://learnku.com/" + repo;
        Request request = new Request.Builder().url(url).build();

        try (FileWriter fileWriter = new FileWriter(file)) {
            Response response = httpClient.newCall(request).execute();
            if (response.isSuccessful() && response.body() != null) {
                String html = Objects.requireNonNull(response.body()).string();
                Document document = Parser.parse(html, "");
                Elements element = document.getElementsByClass("simple topic-list rm-link-color mt-0");
                List<Node> nodes = element.get(0).childNodes();

                fileWriter.write("|--------------------标题 链接-----------------------|" + "\n");

                for (int i = 0; i < nodes.size(); i++) {
                    if (i % 2 == 0) {
                        continue;
                    }

                    Node a = nodes.get(i).childNodes().get(5);
                    String href = a.attr("href");
                    String text = a.childNodes().get(1).childNodes().get(0).toString();

                    fileWriter.write(text + " " + href + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }









    }
}
