import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private int n;
    private int m;
    private int[] parents;
    private Set<Integer> trees;
    private int caseNum;

    public int find(int x) {
        if (parents[x] == x) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a == b) {
            parents[b] = a;
            parents[a] = 0;
            return;
        }

        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        caseNum = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            parents = new int[n + 1];
            for(int i=1; i<=n; i++) {
                parents[i] = i;
            }

            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                union(from, to);
            }

            trees = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                int root = find(i);
                if (root > 0) {
                    trees.add(root);
                }
            }

            sb.append("Case " + caseNum);
            if (trees.isEmpty()) {
                sb.append(": No trees.");
            } else if (trees.size() == 1) {
                sb.append(": There is one tree.");
            } else {
                sb.append(": A forest of " + trees.size() + " trees.");
            }
            sb.append('\n');
            caseNum++;
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
