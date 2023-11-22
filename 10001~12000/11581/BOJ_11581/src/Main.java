import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    int N;
    ArrayList<Integer>[] edges;
    int[] isVisited;
    String res;

    public void isCycle(int here) {
        isVisited[here] = -1;

        for (int next : edges[here]) {
            if (isVisited[next] == -1) {
                res = "CYCLE";
                return;
            }
            isCycle(next);
        }

        isVisited[here] = 1;
    }

    public void solution() {
        res = "NO CYCLE";
        isCycle(1);
        System.out.println(res);
    }

    public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N - 1; i++) {
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                edges[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        isVisited = new int[N + 1];
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.init();
        main.solution();
    }
}
