import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.MemoryManagerMXBean;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private int N;
    private int K;
    private int Q;
    private int M;
    private int[] snooze;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        snooze = new int[N + 3];
        st = new StringTokenizer(br.readLine());
        while (K-- > 0) {
            snooze[Integer.parseInt(st.nextToken())] = -1;
        }

        st = new StringTokenizer(br.readLine());
        while (Q-- > 0) {
            int input = Integer.parseInt(st.nextToken());

            if (snooze[input] == -1) {
                continue;
            }

            int idx = input;
            while (idx <= N + 2) {
                if (snooze[idx] != -1) {
                    snooze[idx] = 1;
                }
                idx += input;
            }
        }

        for (int i = 3; i <= N + 2; i++) {
            if (snooze[i] == -1 || snooze[i] == 0) {
                snooze[i] = snooze[i - 1] + 1;
            } else {
                snooze[i] = snooze[i - 1];
            }
        }

        int from;
        int to;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());

            sb.append(snooze[to] - snooze[from - 1]).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}