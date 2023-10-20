import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    int T;
    int N;
    int M;
    int[] rank;

    public int find(int x) {
        if (rank[x] < 0) {
            return x;
        }
        return rank[x] = find(rank[x]);
    }

    public boolean union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a == b) {
            return false;
        }

        if (rank[a] < rank[b]) {
            rank[a] += rank[b];
            rank[b] = a;
        } else {
            rank[b] += rank[a];
            rank[a] = b;
        }

        return true;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            boolean isNotTree = true;
            if (M != N - 1) {
                sb.append("graph").append('\n');
                isNotTree = false;
            }

            rank = new int[N + 1];
            Arrays.fill(rank, -1);


            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (!isNotTree) {
                    continue;
                }

                if (!union(a, b)) {
                    sb.append("graph").append('\n');
                    isNotTree = false;
                }
            }

            if (isNotTree) {
                sb.append("tree").append('\n');
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
