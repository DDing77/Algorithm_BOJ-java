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
    private int S;
    private int P;
    private ArrayList<Integer>[] edges;
    private int res;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        Queue<Integer> que = new ArrayDeque<>();
        boolean[] isVisited = new boolean[N + 1];
        que.add(P);
        isVisited[P] = true;

        int depth = -1;
        int cnt = 0;
        loop:
        while (!que.isEmpty()) {
            depth++;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int cur = que.poll();

                if (cur <= S) {
                    res += depth;
                    cnt++;

                    if (cnt == 2) {
                        break loop;
                    }
                } else {
                    for (int next : edges[cur]) {
                        if (!isVisited[next]) {
                            que.add(next);
                            isVisited[next] = true;
                        }
                    }
                }
            }
        }

        System.out.println(N - res - 1);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
