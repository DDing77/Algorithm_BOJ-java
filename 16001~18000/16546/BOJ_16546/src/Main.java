import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private boolean[] passed;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        passed = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            passed[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 1; i <= N; i++) {
            if (!passed[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
