import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int N;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5 * N; j++) {
                sb.append("@");
            }
            sb.append("\n");
        }

        for (int i = 0; i < 3 * N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append("@");
            }
            sb.append("\n");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5 * N; j++) {
                sb.append("@");
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
