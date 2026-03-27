import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i < N; i++) {
            sb.append(i).append(" ");
            if (i % 6 == 0) {
                sb.append("Go! ");
            }
        }

        sb.append(N).append(" ").append("Go!");
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
