import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    int N;
    boolean[] isVisited;
    ArrayList<EdgeInfo>[] edges;
    long res;

    public void execDFS(int cur, long distance) {
        isVisited[cur] = true;
        res = Math.max(res, distance);

        for (EdgeInfo edge : edges[cur]) {
            if (!isVisited[edge.next]) {
                execDFS(edge.next, distance + edge.distance);
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            edges[from].add(new EdgeInfo(to, distance));
            edges[to].add(new EdgeInfo(from, distance));
        }

        isVisited = new boolean[N + 1];
        isVisited[1] = true;
        execDFS(1, 0L);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static class EdgeInfo {
        int next;
        int distance;

        public EdgeInfo(int next, int distance) {
            this.next = next;
            this.distance = distance;
        }
    }
}
