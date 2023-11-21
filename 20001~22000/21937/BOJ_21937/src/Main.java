import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    int N;
    int M;
    int X;
    ArrayList<Integer>[] edges;
    boolean[] isVisited;
    int res;

    public int execDFS(int here) {
        int cnt = 1;
        isVisited[here] = true;

        for (int next : edges[here]) {
            if (isVisited[next]) {
                continue;
            }
            cnt += execDFS(next);
        }
        return cnt;
    }

    public void solution() {
        res = execDFS(X) - 1;
        System.out.println(res);
    }

    public void init() throws IOException {
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
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            edges[from].add(to);
        }

        isVisited = new boolean[N + 1];
        X = Integer.parseInt(br.readLine());
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.init();
        main.solution();
    }
}
