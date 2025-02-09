import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int N;
    private int M;
    private ArrayList<Integer>[] edges;
    private int[] nodeTypes;

    private boolean execDFS(int curNodeNum, int type) {

        nodeTypes[curNodeNum] = type;
        boolean flag = false;
        for (int nextNodeNum : edges[curNodeNum]) {
            if (nodeTypes[nextNodeNum] == 0) {
                flag |= execDFS(nextNodeNum, type * -1);
            } else if (nodeTypes[nextNodeNum] == type) {
                flag = true;
            }
        }
        return flag;
    }

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            edges = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                edges[i] = new ArrayList<>();
            }

            int from = 0;
            int to = 0;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                edges[from].add(to);
                edges[to].add(from);
            }

            nodeTypes = new int[N + 1];

            if (execDFS(from, 1)) {
                sb.append("impossible");
            } else {
                sb.append("possible");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
