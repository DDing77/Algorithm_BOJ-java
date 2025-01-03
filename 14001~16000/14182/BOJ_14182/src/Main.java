import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private void solution() throws IOException {

        while (true) {
            int revenue = Integer.parseInt(br.readLine());

            if (revenue == 0) {
                break;
            }

            if (revenue <= 1_000_000) {
                sb.append(revenue);
            } else if (revenue <= 5_000_000) {
                sb.append((int) (revenue * 0.9));
            } else {
                sb.append((int) (revenue * 0.8));
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

