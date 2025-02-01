import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int K;
    private ArrayList<Integer>[] edges;
    private int[] weights;
    private boolean[] isVisited;
    private int res;

    private void execDFS(int curNodeNum, int depth) {

        if (weights[curNodeNum] == K) {
            res = depth;
            return;
        }

        isVisited[curNodeNum] = true;

        for (int nextNode : edges[curNodeNum]) {
            if (!isVisited[nextNode]) {
                execDFS(nextNode, depth + 1);
            }
        }

        isVisited[curNodeNum] = false;
    }

    private void solution() throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        edges = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            edges[parent].add(child);
        }

        weights = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        isVisited = new boolean[N];
        execDFS(0, 0);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
