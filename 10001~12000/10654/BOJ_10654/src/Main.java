import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private long T;
    private long[] positions;
    private long[] speeds;
    private int res;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Long.parseLong(st.nextToken());

        positions = new long[N];
        speeds = new long[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            positions[i] = Long.parseLong(st.nextToken());
            speeds[i] = Long.parseLong(st.nextToken());
        }

        long minEnd = Long.MAX_VALUE;
        for (int i = N - 1; i >= 0; i--) {
            long end = positions[i] + speeds[i] * T;
            if (end < minEnd) {
                res++;
                minEnd = end;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
