import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int[] inorders;
    private List<int[]>[] edges;
    private List<int[]>[] edgesRev;
    private int[] maxDistances;
    private int start;
    private int end;
    private boolean[] isVisited;
    private int res;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        inorders = new int[N + 1];
        edges = new ArrayList[N + 1];
        edgesRev = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
            edgesRev[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[a].add(new int[]{b, c});
            edgesRev[b].add(new int[]{a, c});
            inorders[b]++;
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        maxDistances = new int[N + 1];
        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int[] nextNode : edges[cur]) {
                maxDistances[nextNode[0]] = Math.max(maxDistances[nextNode[0]], maxDistances[cur] + nextNode[1]);
                inorders[nextNode[0]]--;

                if (inorders[nextNode[0]] == 0) {
                    que.add(nextNode[0]);
                }
            }
        }

        Queue<Integer> queRev = new ArrayDeque<>();
        queRev.add(end);
        isVisited = new boolean[N + 1];
        isVisited[end] = true;
        while (!queRev.isEmpty()) {
            int cur = queRev.poll();
            for (int[] nextNode : edgesRev[cur]) {
                if (maxDistances[cur] == maxDistances[nextNode[0]] + nextNode[1]) {
                    res++;
                    if (!isVisited[nextNode[0]]) {
                        isVisited[nextNode[0]] = true;
                        queRev.add(nextNode[0]);
                    }
                }
            }
        }

        sb.append(maxDistances[end]).append("\n").append(res);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
