import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] A;
    static int[] cnt;
    static int res;

    static void execBFS() {
        Queue<Integer> que = new LinkedList<>();
        cnt = new int[N];
        res = -1;
        que.add(0);

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int i = 1; i <= A[cur]; i++) {
                if (cur + i == N - 1) {
                    res = cnt[cur] + 1;
                    return;
                }

                if (cnt[cur + i] == 0) {
                    que.add(cur + i);
                    cnt[cur + i] += cnt[cur] + 1;
                }
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        execBFS();

        if (res == -1) {
            System.out.println("-1");
            return;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
