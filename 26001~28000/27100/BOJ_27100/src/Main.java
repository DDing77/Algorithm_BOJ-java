import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    int S;
    int E;
    int[] stamps;
    boolean[] isVisited;
    int res;


    public void execBFS() {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0, 0});
        isVisited[0] = true;
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (cur[1] == E) {
                continue;
            }

            for (int i = 0; i < stamps.length; i++) {
                int next = cur[0] + stamps[i];
                if (isVisited[next]) {
                    continue;
                }
                que.add(new int[]{next, cur[1] + 1});
                isVisited[next] = true;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        S = st.countTokens();
        stamps = new int[S];
        for (int i = 0; i < S; i++) {
            stamps[i] = Integer.parseInt(st.nextToken());
        }

        isVisited = new boolean[1_000 * E + 1];
        execBFS();
        res = 0;
        int cnt = 0;
        for (int i = 1; i < isVisited.length; i++) {
            if (!isVisited[i]) {
                cnt = 0;
                continue;
            }
            cnt++;
            res = Math.max(res, cnt);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
