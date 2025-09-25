import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int[] inOrder;
    private ArrayList<int[]>[] edges;
    private long[] sum;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        inOrder = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[a].add(new int[]{b, c});
            inOrder[b]++;
        }

        sum = new long[N + 1];
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (inOrder[i] == 0) {
                sum[i] = 1L;
                que.add(i);
            }
        }

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int[] nextNode : edges[cur]) {
                sum[nextNode[0]] += sum[cur] * nextNode[1];
                inOrder[nextNode[0]]--;
                if (inOrder[nextNode[0]] == 0) {
                    que.add(nextNode[0]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (edges[i].isEmpty()) {
                sb.append(i).append(" ").append(sum[i]).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
