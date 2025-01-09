import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int P;
    private ArrayList<Integer>[] edges;
    private int res;

    private void execBFS(int nodeNum) {

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{nodeNum, 1});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int nextNodeNum : edges[cur[0]]) {
                res = Math.max(res, cur[1] + 1);
                queue.add(new int[]{nextNodeNum, cur[1] + 1});
            }
        }
    }

    private void solution() throws IOException {

        P = Integer.parseInt(br.readLine());
        edges = new ArrayList[P + 1];
        for (int i = 0; i < P + 1; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < P - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeNum = Integer.parseInt(st.nextToken());

            int to1 = Integer.parseInt(st.nextToken());
            if (to1 != 0) {
                edges[nodeNum].add(to1);
            }

            int to2 = Integer.parseInt(st.nextToken());
            if (to2 != 0) {
                edges[nodeNum].add(to2);
            }
        }

        execBFS(1);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}

