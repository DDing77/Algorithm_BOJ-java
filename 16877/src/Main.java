import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int res;
    static int[] dp;
    static int[] grundy;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        res = 0;
        dp = new int[34];
        dp[1] = 1;
        grundy = new int[3000001];
        grundy[0] = 0;
        grundy[1] = 1;
        grundy[2] = 2;
        grundy[3] = 3;
        check = new boolean[16];

        for (int i = 2; i <= 33; i++) dp[i] = dp[i - 2] + dp[i - 1];

        for (int i = 4; i <= 3000000; i++) {
            Arrays.fill(check, false);

            for (int j = 2; j <= 33; j++) {
                if (dp[j] <= i) check[grundy[i - dp[j]]] = true;
                else {
                    for (int k = 0; k <= 15; k++) {
                        if (!check[k]) {
                            grundy[i] = k;
                            break;
                        }
                    }
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            res ^= grundy[temp];
        }

        if (res == 0) System.out.println("cubelover");
        else System.out.println("koosaga");
    }
}
