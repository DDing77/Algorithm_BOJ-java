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

        long ans = 0L;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long C = Long.parseLong(st.nextToken());
            long K = Long.parseLong(st.nextToken());

            if (K >= 1) {
                ans += C * K;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
