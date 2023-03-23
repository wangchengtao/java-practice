package app;

import org.kohsuke.github.GHIssueState;
import org.kohsuke.github.GHPullRequest;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Crawler2 {
    public static void main(String[] args) throws IOException {
        File file = new File(System.getProperty("user.dir") + "/target/test.csv");
        saveArticleToFile("golang/go", 10, file);
    }

    public static void saveArticleToFile(String repo, int n, File file) throws IOException {
        GitHub github = GitHub.connectAnonymously();
        GHRepository repository = github.getRepository(repo);
        List<GHPullRequest> pullRequests = repository.getPullRequests(GHIssueState.OPEN);
        List<String> list = new ArrayList<>();
        list.add("number,author,title");

        for (GHPullRequest request : pullRequests) {
            list.add(request.getNumber() + "," + request.getUser().getLogin() + "," + request.getTitle());

            if (list.size() > n) {
                break;
            }
        }

        try (FileWriter fileWriter = new FileWriter(file, true)) {
            for (String line : list) {
                fileWriter.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // FileWriter fileWriter = new FileWriter(file, true);
        //
        // for (String s : list) {
        //     fileWriter.write(s + "\n");
        // }
        //
        // fileWriter.close();

    }
}