import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    static final List<String> pikachu = List.of("pi", "ka", "chu");
    String input;

    private void solution() throws IOException {

        input = br.readLine();

        for (String s : pikachu) {
            input = input.replaceAll(s, "**");
        }

        input = input.replaceAll("\\*", "");

        if (input.equals("")) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
