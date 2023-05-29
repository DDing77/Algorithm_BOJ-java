import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int m, n, x, Q;
    static int LogN;
    static int[][] parent;

    static void getLogN() {
        LogN = 0;
        for (int i = 1; i < 500000; i *= 2) LogN++;
    }

    static void makeSpareTable() {
        for (int i = 1; i <= LogN; i++) {
            for (int j = 1; j <= m; j++) parent[i][j] = parent[i - 1][parent[i - 1][j]];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        getLogN();
        m = Integer.parseInt(br.readLine());
        parent = new int[LogN + 1][m + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) parent[0][i] = Integer.parseInt(st.nextToken());
        makeSpareTable();

        Q = Integer.parseInt(br.readLine());
        for (int i = 1; i <= Q; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            for (int j = 0; j < LogN; j++) if ((n & (1 << j)) >= 1) x = parent[j][x];
            sb.append(x).append('\n');
        }
        System.out.print(sb);
    }
}

