import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private ArrayList<Integer>[] edges;
    private int[] orders;
    private boolean[] isVisited;

    private boolean check;
    private int idx;

    private void execDFS(int cur, int parent) {

        if (!check) {
            return;
        }

        isVisited[cur] = true;
        Set<Integer> set = new HashSet<>();
        for (int next : edges[cur]) {
            if (next != parent) {
                set.add(next);
            }
        }

        int len = set.size();
        for (int i = 0; i < len; i++) {
            if (set.remove(orders[idx])) {
                execDFS(orders[idx++], cur);
            } else {
                check = false;
                return;
            }
        }
    }

    private void solution() throws IOException {

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

        st = new StringTokenizer(br.readLine());
        orders = new int[N];
        for (int i = 0; i < N; i++) {
            orders[i] = Integer.parseInt(st.nextToken());
        }

        check = true;
        if (orders[0] != 1) {
            check = false;
        } else {
            idx = 1;
            isVisited = new boolean[N + 1];
            execDFS(1, 0);
        }

        if (!check) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
