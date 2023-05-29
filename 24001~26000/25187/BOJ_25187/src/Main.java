import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private int N;
    private int M;
    private int Q;
    private int[] parents;
    private int[] cnt;

    public int find(int x) {
        if (parents[x] < 0) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a == b) {
            return;
        }

        if (parents[a] <= parents[b]) {
            parents[a] += parents[b];
            parents[b] = a;
            cnt[a] += cnt[b];
        } else {
            parents[b] += parents[a];
            parents[a] = b;
            cnt[b] += cnt[a];
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        cnt = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            parents[i] = -1;
            cnt[i] = Integer.parseInt(st.nextToken());
            if (cnt[i] == 0) {
                cnt[i] = -1;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < Q; i++) {
            if (cnt[find(Integer.parseInt(br.readLine()))] > 0) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
