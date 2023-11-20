import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    int N;
    ArrayList<Integer>[] edges;
    boolean[] isVisited;
    int res;

    public void execDFS(int here, int depth) {
        isVisited[here] = true;
        boolean isLeaf = true;
        for (int next : edges[here]) {
            if (isVisited[next]) {
                continue;
            }
            isLeaf = false;
            execDFS(next, depth + 1);
        }

        if (isLeaf) {
            res += depth;
        }
    }

    public void solution() {
        execDFS(1, 0);

        if ((res & 1) == 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public void initData() throws IOException {
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
            edges[from].add(to);
            edges[to].add(from);
        }

        isVisited = new boolean[N + 1];
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.initData();
        main.solution();
    }
}
