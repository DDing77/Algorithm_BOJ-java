import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int N;

    private void solution() throws IOException {

        while (true) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) {
                System.out.print(sb);
                return;
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 0; j < i; j++) {
                    sb.append("*");
                }
                sb.append("\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
