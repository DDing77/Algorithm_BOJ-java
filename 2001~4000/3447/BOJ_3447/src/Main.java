import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private void solution() throws IOException {

        String input = "";
        while ((input = br.readLine()) != null) {
            while (input.contains("BUG")) {
                input = input.replace("BUG", "");
            }
            sb.append(input).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
