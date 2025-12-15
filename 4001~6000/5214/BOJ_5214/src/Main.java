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
    private int K;
    private int M;
    private ArrayList<Integer>[] edges;
    private int[] cntArr;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1 + M];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                int nodeNum = Integer.parseInt(st.nextToken());
                edges[nodeNum].add(N + i + 1);
                edges[N + i + 1].add(nodeNum);
            }
        }

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{1, 1});
        boolean[] isVisited = new boolean[N + 1 + M];
        isVisited[1] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0] == N) {
                System.out.println(cur[1] / 2 + 1);
                return;
            }

            for (int nextNodeNum : edges[cur[0]]) {
                if (isVisited[nextNodeNum]) {
                    continue;
                }
                isVisited[nextNodeNum] = true;
                que.add(new int[]{nextNodeNum, cur[1] + 1});
            }
        }

        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
