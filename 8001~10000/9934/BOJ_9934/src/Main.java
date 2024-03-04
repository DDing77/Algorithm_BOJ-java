import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    ArrayList<Integer>[] level;
    int[] node;

    private void findTree(int left, int right, int depth) {
        if (depth == N) {
            return;
        }

        int mid = (left + right) >> 1;

        level[depth].add(node[mid]);

        findTree(left, mid - 1, depth + 1);
        findTree(mid + 1, right, depth + 1);
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        level = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            level[i] = new ArrayList<>();
        }

        node = new int[(int) (Math.pow(2, N) - 1)];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < node.length; i++) {
            node[i] = Integer.parseInt(st.nextToken());
        }

        findTree(0, node.length - 1, 0);

        for (int i = 0; i < N; i++) {
            for (int nodeNum : level[i]) {
                sb.append(nodeNum).append(" ");
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
