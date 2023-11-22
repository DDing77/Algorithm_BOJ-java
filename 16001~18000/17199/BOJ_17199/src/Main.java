import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    int N;
    boolean[] isVisited;
    ArrayList<Integer>[] edges;

    public void execDFS(int here) {
        isVisited[here] = true;
        for (int next : edges[here]) {
            if (!isVisited[next]) {
                execDFS(next);
            }
        }
    }

    public void solution() {
        for (int i = 1; i <= N; i++) {
            isVisited = new boolean[N + 1];
            execDFS(i);
            boolean isAll = true;
            for (int j = 1; j <= N; j++) {
                if (!isVisited[j]) {
                    isAll = false;
                }
            }
            if (isAll) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }

    public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            edges[from].add(to);
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.init();
        main.solution();
    }
}
