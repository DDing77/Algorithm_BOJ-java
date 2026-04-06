import java.io.*;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[][] arr;
    private int[] parent;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        parent = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i][j] == 0) union(i, j);
            }
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int root = find(i);
            map.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        for (List<Integer> group : map.values()) {
            if (group.size() < 2) {
                System.out.println(0);
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                boolean same = find(i) == find(j);

                if (same && arr[i][j] == 1) {
                    System.out.println(0);
                    return;
                }

                if (!same && arr[i][j] == 0) {
                    System.out.println(0);
                    return;
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>(map.values());

        for (List<Integer> group : result) {
            Collections.sort(group);
        }

        result.sort(Comparator.comparingInt(a -> a.get(0)));

        sb.append(result.size()).append("\n");

        for (List<Integer> group : result) {
            for (int x : group) {
                sb.append(x + 1).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) parent[pb] = pa;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}