import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static String parent;
    static String[] pattern;
    static int[][] failTable;
    static int[] dp;
    static int[] mem;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        parent = br.readLine();

        n = Integer.parseInt(br.readLine());

        pattern = new String[505];
        failTable = new int[505][10005];
        mem = new int[505];
        dp = new int[100005];

        for (int i = 0; i < n; i++) {
            pattern[i] = br.readLine();

            int k = 0;
            for (int j = 1; j < pattern[i].length(); j++) {
                while (k > 0 && pattern[i].charAt(j) != pattern[i].charAt(k)) {
                    k = failTable[i][k - 1];
                }
                if (pattern[i].charAt(j) == pattern[i].charAt(k)) {
                    failTable[i][j] = ++k;
                }
            }
        }

        for (int i = 0; i < parent.length(); i++) {
            if (i > 0) dp[i] = dp[i - 1];
            for (int j = 0; j < n; ++j) {
                int M = pattern[j].length();
                while (mem[j] > 0 && parent.charAt(i) != pattern[j].charAt(mem[j])) {
                    mem[j] = failTable[j][mem[j] - 1];
                }
                if (parent.charAt(i) == pattern[j].charAt(mem[j])) {
                    if (mem[j] == M - 1) {
                        int temp = i - M >= 0 ? dp[i - M] : 0;
                        temp += M;
                        dp[i] = Math.max(dp[i], temp);
                        mem[j] = failTable[j][mem[j]];
                    } else {
                        mem[j]++;
                    }
                }
            }
        }
        System.out.println(dp[parent.length() - 1]);
    }
}
