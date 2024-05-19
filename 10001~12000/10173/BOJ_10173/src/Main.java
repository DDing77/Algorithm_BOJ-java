import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private String input;

    private void solution() throws IOException {

        while (true) {
            input = br.readLine();
            if (input.equals("EOI")) {
                break;
            }

            input = input.toUpperCase();
            if (input.contains("NEMO")) {
                sb.append("Found");
            } else {
                sb.append("Missing");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
