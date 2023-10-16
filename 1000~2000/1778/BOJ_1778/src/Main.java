import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    int N;
    int M;
    int[] parents;
    int res;

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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            parents = new int[N + 1];
            Arrays.fill(parents, -1);
            res = N;
            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                if (union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))) {
                    res--;
                }
            }

            sb.append("Case ").append(tc++).append(": ").append(res).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
