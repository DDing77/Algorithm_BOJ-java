import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private void solution() throws IOException {
        String line;
        StringBuilder sb = new StringBuilder();

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            double w = Double.parseDouble(line);
            if (w == 0.0) {
                break;
            }

            double res = 1.0;
            double cur = 1.0;
            for (int i = 0; i < 4; i++) {
                cur *= w;
                res += cur;
            }

            sb.append(String.format(java.util.Locale.US, "%.2f%n", res));
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}