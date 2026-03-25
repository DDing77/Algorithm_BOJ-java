import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private long[] waters;
    private boolean[] switches;
    private int Q;
    private long sum = 0L;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        waters = new long[N];
        for (int i = 0; i < N; i++) {
            waters[i] = Long.parseLong(st.nextToken());
            sum += waters[i];
        }

        sb.append(sum).append("\n");

        Q = Integer.parseInt(br.readLine());
        switches = new boolean[N];
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken()) - 1;

            if (op == 1) {
                int x = Integer.parseInt(st.nextToken());
                if (!switches[idx]) {
                    if (waters[idx] < x) {
                        sum += x - waters[idx];
                    } else {
                        sum -= waters[idx] - x;
                    }
                }
                waters[idx] = x;
            } else if (op == 2) {
                switches[idx] = !switches[idx];
                if (switches[idx]) {
                    sum -= waters[idx];
                } else {
                    sum += waters[idx];
                }
            }

            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
