import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private int N;
    private int M;
    private int[] parents;
    private int res;

    public int find(int x) {
        if (parents[x] < 0) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    public boolean union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a == b) {
            return false;
        }

        if (parents[a] <= parents[b]) {
            parents[a] += parents[b];
            parents[b] = a;
        } else {
            parents[b] += parents[a];
            parents[a] = b;
        }

        return true;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        Arrays.fill(parents, -1);

        int deleteCnt = 0;
        int creteCnt = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (!union(from, to)) {
                deleteCnt++;
            } else {
                creteCnt++;
            }
        }

        res = (N - 1) - creteCnt + deleteCnt;
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
