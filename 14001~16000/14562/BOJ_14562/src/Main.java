import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    int C;

    public int execBFS(int S, int T) {
        int res = 0;
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{S, T, 0});

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0] == cur[1]) {
                res = cur[2];
                break;
            }

            if (cur[0] > cur[1]) {
                continue;
            }
            que.add(new int[]{cur[0] * 2, cur[1] + 3, cur[2] + 1});
            que.add(new int[]{cur[0] + 1, cur[1], cur[2] + 1});

        }

        return res;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            st = new StringTokenizer(br.readLine());
            sb.append(execBFS(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append('\n');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
