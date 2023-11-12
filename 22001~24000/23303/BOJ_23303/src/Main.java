import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    String input;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        if (input.contains("D2") || input.contains("d2")) {
            System.out.println("D2");
        } else {
            System.out.println("unrated");
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}