import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private ArrayList<Integer>[] edges;
    private boolean[] isVisited;
    private ArrayList<Integer> groupSizes;
    private int totalEdgeCnt;

    private int execDFS(int curNode) {

        int cnt = 1;
        isVisited[curNode] = true;

        for (int next : edges[curNode]) {
            if (!isVisited[next]) {
                cnt += execDFS(next);
            }
        }
        return cnt;
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        edges = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                if (input.charAt(j) == 'Y') {
                    edges[i].add(j);
                    totalEdgeCnt++;
                }
            }
        }

        isVisited = new boolean[N];
        groupSizes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) {
                groupSizes.add(execDFS(i));
            }
        }

        int needSum = 0;
        for (int groupSize : groupSizes) {
            if (groupSize == 1) {
                System.out.println(-1);
                return;
            }
            needSum += (groupSize - 1);
        }

        if (groupSizes.size() - 1 <= (totalEdgeCnt / 2) - needSum) {
            System.out.println(groupSizes.size() - 1);
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
