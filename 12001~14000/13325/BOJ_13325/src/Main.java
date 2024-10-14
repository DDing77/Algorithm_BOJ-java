import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int K;
    private int[] nodes;
    private int res;

    private int execDFS(int cur, int depth) {

        if (depth == K) {
            res += nodes[cur];
            return nodes[cur];
        }

        int left = execDFS(cur << 1, depth + 1);
        int right = execDFS(cur << 1 | 1, depth + 1);
        int diff = Math.abs(left - right);
        res += nodes[cur] + diff;

        return nodes[cur] + Math.max(left, right);
    }

    private void solution() throws IOException {

        K = Integer.parseInt(br.readLine());

        int length = (1 << (K + 1)) - 1;
        nodes = new int[length + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 2; i < nodes.length; i++) {
            nodes[i] = Integer.parseInt(st.nextToken());
        }

        execDFS(1, 0);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
