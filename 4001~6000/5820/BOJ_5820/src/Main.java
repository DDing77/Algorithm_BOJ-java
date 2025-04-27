import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static int INF = 1_000_000_000;

    private int N;
    private int K;
    private List<Integer>[] edges;
    private List<Integer>[] weights;
    private int[] sizes;
    private boolean[] isCent;
    private int[] resMin;
    private int[] curMin;
    private List<Integer> dfsCache1;
    private List<Integer> dfsCache2;
    private int res;

    private int getSize(int pre, int cur) {
        sizes[cur] = 1;
        for (int i = 0; i < edges[cur].size(); i++) {
            int next = edges[cur].get(i);
            if (next != pre && !isCent[next]) {
                sizes[cur] += getSize(cur, next);
            }
        }
        return sizes[cur];
    }

    private int getCentroid(int pre, int cur, int size) {
        for (int i = 0; i < edges[cur].size(); i++) {
            int next = edges[cur].get(i);
            if (next != pre && !isCent[next] && sizes[next] > size / 2) {
                return getCentroid(cur, next, size);
            }
        }
        return cur;
    }

    private void dfs(int pre, int cur, int sum, int count) {
        if (sum > K) {
            return;
        }

        if (sum == K) {
            res = Math.min(res, count);
        }

        if (resMin[K - sum] != INF) {
            res = Math.min(res, resMin[K - sum] + count);
        }

        curMin[sum] = Math.min(curMin[sum], count);

        dfsCache1.add(sum);
        dfsCache2.add(sum);

        for (int i = 0; i < edges[cur].size(); i++) {
            int next = edges[cur].get(i);
            if (next != pre && !isCent[next]) {
                dfs(cur, next, sum + weights[cur].get(i), count + 1);
            }
        }
    }

    private void dq(int nodeNum) {
        int curSize = getSize(-1, nodeNum);
        int centroid = getCentroid(-1, nodeNum, curSize);
        for (int i = 0; i < edges[centroid].size(); i++) {
            int next = edges[centroid].get(i);
            if (!isCent[next]) {
                dfs(centroid, next, weights[centroid].get(i), 1);
                for (int sum : dfsCache1) {
                    resMin[sum] = Math.min(resMin[sum], curMin[sum]);
                }
                dfsCache1.clear();
            }
        }

        for (int sum : dfsCache2) {
            resMin[sum] = INF;
            curMin[sum] = INF;
        }
        dfsCache2.clear();
        isCent[centroid] = true;
        for (int i = 0; i < edges[centroid].size(); i++) {
            int next = edges[centroid].get(i);
            if (!isCent[next]) {
                dq(next);
            }
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        edges = new List[N];
        weights = new List[N];
        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
            weights[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            weights[a].add(w);
            edges[b].add(a);
            weights[b].add(w);
        }

        resMin = new int[K + 1];
        curMin = new int[K + 1];
        Arrays.fill(resMin, INF);
        Arrays.fill(curMin, INF);

        dfsCache1 = new ArrayList<>();
        dfsCache2 = new ArrayList<>();
        res = INF;
        sizes = new int[N];
        isCent = new boolean[N];
        dq(0);

        if (res == INF) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
