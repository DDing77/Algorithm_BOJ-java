import java.io.IOException;

public class Main {

    static int N;
    static int[][] dp;
    static int res;
    static int[] professor;
    static int[] me;

    public static int readInt() throws IOException {
        int n = System.in.read() & 15;
        int c;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }

    public static void solution() throws IOException {
        N = readInt();
        dp = new int[N + 1][N + 1];
        professor = new int[2];
        me = new int[2];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int cur = readInt();
                if (cur == 5) {
                    professor[0] = i;
                    professor[1] = j;
                }

                if (cur == 2) {
                    me[0] = i;
                    me[1] = j;
                }

                if (cur == 1) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + 1;
                    continue;
                }

                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
            }
        }

        double distance = Math.sqrt(Math.pow(me[0] - professor[0], 2) + Math.pow(me[1] - professor[1], 2));

        if (distance < 5) {
            System.out.println(0);
            return;
        }


        int rs = me[0] < professor[0] ? me[0] : professor[0];
        int re = me[0] < professor[0] ? professor[0] : me[0];
        int cs = me[1] < professor[1] ? me[1] : professor[1];
        int ce = me[1] < professor[1] ? professor[1] : me[1];

        res = dp[re][ce] + dp[rs - 1][cs - 1] - dp[re][cs - 1] - dp[rs - 1][ce];

        if (res >= 3) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}

