import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final int SIZE = 100_001;
    int A;
    int B;
    int N;
    int M;
    boolean[] isVisited;
    Queue<int[]> que;
    int res;

    public boolean validation(int idx) {
        return 0 <= idx && idx < SIZE && !isVisited[idx];
    }

    public void add(int idx, int cnt) {
        if (validation(idx)) {
            isVisited[idx] = true;
            que.add(new int[]{idx, cnt + 1});
        }
    }

    public void execBFS() {
        isVisited = new boolean[SIZE];
        que = new ArrayDeque<>();
        que.add(new int[]{N, 0});
        isVisited[N] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0] == M) {
                res = cur[1];
                return;
            }

            add(cur[0] + 1, cur[1]);
            add(cur[0] - 1, cur[1]);
            add(cur[0] + A, cur[1]);
            add(cur[0] - A, cur[1]);
            add(cur[0] + B, cur[1]);
            add(cur[0] - B, cur[1]);
            add(cur[0] * A, cur[1]);
            add(cur[0] * B, cur[1]);
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        res = 0;
        execBFS();

        System.out.println(res);

    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
