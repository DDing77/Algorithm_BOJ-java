import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int Q;
    private boolean[] nodes;

    private int find(int targetNodeNum) {

        int nodeNum = targetNodeNum;
        int resNum = 0;
        while (nodeNum != 0) {
            if (nodes[nodeNum]) {
                resNum = nodeNum;
            }
            nodeNum /= 2;
        }

        if (resNum == 0) {
            nodes[targetNodeNum] = true;
        }

        return resNum;
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        nodes = new boolean[N + 1];

        for (int i = 0; i < Q; i++) {
            int targetNodeNum = Integer.parseInt(br.readLine());
            sb.append(find(targetNodeNum)).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
