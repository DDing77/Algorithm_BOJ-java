import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private ArrayList<Integer>[] edges;
    private int[] distances;
    private boolean[] isVisited;
    private boolean isCycle;
    private Queue<Integer> cycleNodes;

    private void findCycle(int preNodeNum, int curNodeNum) {

        isVisited[curNodeNum] = true;

        for (int nextNodeNum : edges[curNodeNum]) {
            if (!isVisited[nextNodeNum]) {
                findCycle(curNodeNum, nextNodeNum);

                if (isCycle) {
                    if (distances[nextNodeNum] != 0) {
                        cycleNodes.add(nextNodeNum);
                        distances[nextNodeNum] = 0;
                    } else {
                        isCycle = false;
                    }
                    return;
                }
            } else if (isVisited[nextNodeNum] && preNodeNum != nextNodeNum) {
                isCycle = true;
                cycleNodes.add(nextNodeNum);
                distances[nextNodeNum] = 0;
                break;
            }
        }
    }

    private void execBFS() {

        int depth = 1;
        while (!cycleNodes.isEmpty()) {
            int size = cycleNodes.size();
            for (int i = 0; i < size; i++) {
                int nodeNum = cycleNodes.poll();
                for (int nextNodeNum : edges[nodeNum]) {
                    if (distances[nextNodeNum] == -1) {
                        distances[nextNodeNum] = depth;
                        cycleNodes.add(nextNodeNum);
                    }
                }
            }
            depth++;
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        edges = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges[from].add(to);
            edges[to].add(from);
        }

        distances = new int[N + 1];
        Arrays.fill(distances, -1);

        isVisited = new boolean[N + 1];
        cycleNodes = new ArrayDeque<>();

        findCycle(0, 1);

        execBFS();

        for (int i = 1; i <= N; i++) {
            sb.append(distances[i]).append(" ");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
