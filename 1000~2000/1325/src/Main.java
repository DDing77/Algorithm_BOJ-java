import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private ArrayList<Integer>[] edges;
    private int[] count;
    private boolean[][] isVisited;
    private int max;

    private void execBFS(int start) {

        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);

        while (!que.isEmpty()) {
            int cur = que.poll();
            if (isVisited[start][cur]) {
                continue;
            }
            count[start]++;
            isVisited[start][cur] = true;

            for (int next : edges[cur]) {
                if (isVisited[start][next]) {
                    continue;
                }
                if (next < start) {
                    for (int i = 1; i <= N; i++) {
                        if (isVisited[start][i]) {
                            continue;
                        }
                        if (isVisited[next][i]) {
                            count[start]++;
                            isVisited[start][i] = true;
                        }
                    }
                } else {
                    que.add(next);
                }
            }
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[b].add(a);
        }

        max = 0;
        isVisited = new boolean[N + 1][N + 1];
        count = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            execBFS(i);
            max = Math.max(max, count[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (max == count[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
