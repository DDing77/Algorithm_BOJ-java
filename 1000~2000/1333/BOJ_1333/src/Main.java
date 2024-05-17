import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int L;
    private int D;
    private boolean[] time;
    private int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        time = new boolean[N * L + 5 * (N - 1) + 1];
        int startTime ;
        for (int i = 0; i < N; i++) {
            startTime = (L + 5) * i;
            for (int j = startTime; j < startTime + L; j++) {
                time[j] = true;
            }
        }

        while (res < time.length) {
            if (!time[res]) {
                break;
            }
            res += D;
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
