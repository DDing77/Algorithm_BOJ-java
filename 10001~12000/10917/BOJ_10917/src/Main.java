import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    int N;
    int M;
    ArrayList<Integer>[] edges;
    int res;

    public void execBFS() {
        boolean[] isVisited = new boolean[N + 1];
        isVisited[1] = true;
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{1, 0});

        res = -1;
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0] == N) {
                res = cur[1];
                return;
            }

            for (int next : edges[cur[0]]) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    que.add(new int[]{next, cur[1] + 1});
                }
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        execBFS();

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
