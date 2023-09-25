import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    int N;
    int S;
    int D;
    int F;
    int B;
    int K;
    boolean[] nodes;
    int res;

    public boolean validate(int idx) {
        if (1 <= idx && idx <= N && !nodes[idx]) {
            return true;
        }
        return false;
    }

    public void execBFS() {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{S, 0});
        nodes[S] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0] == D) {
                res = cur[1];
                break;
            }

            int next = cur[0] + F;
            if (validate(next)) {
                nodes[next] = true;
                que.add(new int[]{next, cur[1] + 1});
            }

            next = cur[0] - B;
            if (validate(next)) {
                nodes[next] = true;
                que.add(new int[]{next, cur[1] + 1});
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nodes = new boolean[N + 1];

        if (K > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                nodes[Integer.parseInt(st.nextToken())] = true;
            }
        }

        res = -1;
        execBFS();

        if (res == -1) {
            System.out.println("BUG FOUND");
        } else {
            System.out.println(res);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
