import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private ArrayList<Integer>[] friendsEdges;
    private ArrayList<Integer>[] enemyEdges;
    private int[] parents;
    private int res;

    private int find(int x) {

        if (parents[x] < 0) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return;
        }

        if (parents[x] <= parents[y]) {
            parents[x] += parents[y];
            parents[y] = x;
        } else {
            parents[y] += parents[x];
            parents[x] = y;
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        friendsEdges = new ArrayList[N + 1];
        enemyEdges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            friendsEdges[i] = new ArrayList<>();
            enemyEdges[i] = new ArrayList<>();
        }

        parents = new int[N + 1];
        Arrays.fill(parents, -1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (type.equals("E")) {
                enemyEdges[from].add(to);
                enemyEdges[to].add(from);
            } else {
//                friendsEdges[from].add(to);
//                friendsEdges[to].add(from);
                union(from, to);
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int myEnemy : enemyEdges[i]) {
                for (int enemyOfEnemy : enemyEdges[myEnemy]) {
                    union(i, enemyOfEnemy);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (parents[i] < 0) {
                res++;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
