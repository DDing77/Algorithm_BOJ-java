import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int M;
    int S;
    ArrayList<Integer>[] edges;
    Set<Integer> fanNode;
    boolean res;

    private void execDFS(int curNode) {

        if (res || fanNode.contains(curNode)) {
            return;
        }

        if (edges[curNode].size() == 0 && !fanNode.contains(curNode)) {
            res = true;
            return;
        }

        for (int next : edges[curNode]) {
            execDFS(next);
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
            edges[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        S = Integer.parseInt(br.readLine());
        fanNode = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            fanNode.add(Integer.parseInt(st.nextToken()));
        }

        res = false;
        execDFS(1);

        if (!res) {
            System.out.println("Yes");
        } else {
            System.out.println("yes");
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
