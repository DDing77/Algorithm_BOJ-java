import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private ArrayList<Integer>[] edges;
    private int[] resDepth;

    private void execDFS(int nodeNum, int depth) {

        resDepth[nodeNum] = depth;

        for (int nextNode : edges[nodeNum]) {
            execDFS(nextNode, depth + 1);
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        edges = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        int rootNodeNum = -1;
        for (int i = 1; i <= N; i++) {
            int parent = Integer.parseInt(br.readLine());

            if (parent == -1) {
                rootNodeNum = i;
                continue;
            }

            edges[parent].add(i);
        }

        resDepth = new int[N + 1];
        execDFS(rootNodeNum, 0);

        for (int i = 1; i <= N; i++) {
            sb.append(resDepth[i]).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
