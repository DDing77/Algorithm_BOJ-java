import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, S, T;
    static int[] discover;
    static boolean[] isFinished;
    static int[] nodeToSCC;
    static Stack<Integer> stack;
    static int idx;
    static int sccIdx;
    static ArrayList<Integer>[] edges;
    static ArrayList<ArrayList<Integer>> SCC;
    static int[] sccInfo;
    static int[] dp;

    static int dfs(int x) {
        discover[x] = ++idx;
        stack.push(x);

        int parent = discover[x];
        for (int next : edges[x]) {
            if (discover[next] == 0) parent = Math.min(parent, dfs(next));
            else if (!isFinished[next]) parent = Math.min(parent, discover[next]);
        }

        if (parent == discover[x]) {
            while (true) {
                int top = stack.pop();
                isFinished[top] = true;
                nodeToSCC[top] = sccIdx + 1;
                if (top == x) break;
            }
            sccIdx++;
        }

        return parent;
    }

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(nodeToSCC[S]);
        dp[nodeToSCC[S]] = sccInfo[nodeToSCC[S]];

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int next : SCC.get(cur)) {
                if (dp[next] < dp[cur] + sccInfo[next]) {
                    dp[next] = dp[cur] + sccInfo[next];
                    que.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        discover = new int[N + 1];
        isFinished = new boolean[N + 1];
        nodeToSCC = new int[N + 1];
        edges = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) edges[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges[from].add(to);
        }

        stack = new Stack<>();
        idx = 0;
        sccIdx = 0;
        for (int i = 1; i <= N; i++) {
            if (discover[i] == 0) dfs(i);
        }

        sccInfo = new int[sccIdx + 1];
        SCC = new ArrayList<>();
        for (int i = 0; i <= sccIdx; i++) SCC.add(new ArrayList<>());

        for (int i = 1; i <= N; i++) {
            sccInfo[nodeToSCC[i]]++;
            for (int next : edges[i]) {
                if (nodeToSCC[i] != nodeToSCC[next]) {
                    SCC.get(nodeToSCC[i]).add(nodeToSCC[next]);
                }
            }
        }

        dp = new int[sccIdx + 1];

        bfs();

        System.out.println(dp[nodeToSCC[T]]);
    }
}
