import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private final int MAX_LENGTH = 100_001;
    private int N, K;
    private int[] times;
    private int[] res;

    public void getResult() {
        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        times[N] = 1;
        res[0] = Integer.MAX_VALUE - 1;
        res[1] = 0;

        while (!que.isEmpty()) {
            int cur = que.poll();

            if (res[0] < times[cur]) {
                return;
            }

            for (int k = 0; k < 3; k++) {
                int next = cur;
                if (k == 0) {
                    next++;
                } else if (k == 1) {
                    next--;
                } else {
                    next *= 2;
                }

                if (next < 0 || next >= MAX_LENGTH) {
                    continue;
                }

                if (next == K) {
                    res[0] = times[cur];
                    res[1]++;
                }

                if (times[next] == 0 || times[next] == times[cur] + 1) {
                    que.add(next);
                    times[next] = times[cur] + 1;
                }
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        times = new int[MAX_LENGTH];
        res = new int[2];

        if(N >= K) {
            sb.append(N - K).append('\n').append(1);
            System.out.println(sb);
            return;
        }

        getResult();

        sb.append(res[0]).append('\n').append(res[1]);
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
