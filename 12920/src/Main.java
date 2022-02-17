import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// author : DDing
// solution : DP
// tip : BitMasking 활용

public class Main {
    static int N, M;
    static int[][] dp;

    static class Product {
        int V;
        int C;

        public Product(int V, int C) {
            this.V = V;
            this.C = C;
        }
    }

    static ArrayList<Product> newN = new ArrayList<>();

    static void solution() {
        for (int i = 1; i <= newN.size(); i++) {
            for (int j = 1; j <= M; j++) {
                if (newN.get(i - 1).V > j) dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - newN.get(i - 1).V] + newN.get(i - 1).C);
                }
            }
        }
        System.out.println(dp[newN.size()][M]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            for (int j = 0; K > 0; j++) {
                int sub = Math.min(1 << j, K);
                int subV = V * sub;
                int subC = C * sub;
                newN.add(new Product(subV, subC));
                K -= sub;
            }
        }

        dp = new int[newN.size() + 1][M + 1];
        solution();
    }
}
