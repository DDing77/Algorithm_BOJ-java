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
    private int K;
    private ArrayList<Integer>[] edges;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 2];
        for (int i = 1; i <= N + 1; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        boolean[] isVisited = new boolean[N + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int blocked = Integer.parseInt(st.nextToken());
            isVisited[blocked] = true;
        }


        int resCnt = 0;
        isVisited[1] = true;
        Queue<Integer> que = new ArrayDeque<>();
        que.add(1);

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int next : edges[cur]) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    que.add(next);
                    resCnt++;
                }
            }
        }

        System.out.println(resCnt);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
