import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String A, B;
    static int[][] dp1, dp2;
    static String res;

    static String LCS(int x1, int x2, int y1, int y2) {
        if (x1 == x2) return "";

        String res = "";
        if (x1 + 1 == x2) {
            for (int i = y1 + 1; i <= y2; i++) {
                if (A.charAt(x2) == B.charAt(i)) {
                    res += B.charAt(i);
                    return res;
                }
            }
            return "";
        }

        int xMid = (x1 + x2) >> 1;
        for (int i = y1; i <= y2; i++) {
            dp2[1][i] = 0;
            dp2[0][i] = dp2[1][i];
            dp1[1][i] = dp2[0][i];
            dp1[0][i] = dp1[1][i];
        }

        for (int i = x1 + 1; i <= xMid; i++) {
            for (int j = y1 + 1; j <= y2; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp1[i % 2][j] = dp1[(i + 1) % 2][j - 1] + 1;
                } else {
                    dp1[i % 2][j] = Math.max(dp1[(i + 1) % 2][j], dp1[i % 2][j - 1]);
                }
            }
        }

        for (int i = x2 - 1; i >= xMid; i--) {
            for (int j = y2 - 1; j >= y1; j--) {
                if (A.charAt(i + 1) == B.charAt(j + 1)) {
                    dp2[i % 2][j] = dp2[(i + 1) % 2][j + 1] + 1;
                } else {
                    dp2[i % 2][j] = Math.max(dp2[(i + 1) % 2][j], dp2[i % 2][j + 1]);
                }
            }
        }

        int yIdx = y1;
        for(int i = y1; i <= y2; i++) {
            if( dp1[xMid % 2][i] + dp2[xMid % 2][i] > dp1[xMid % 2][ yIdx] + dp2[xMid %2][yIdx]) {
                yIdx = i;
            }
        }

        return LCS(x1, xMid, y1, yIdx) + LCS(xMid, x2 , yIdx, y2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        A = br.readLine();
        B = br.readLine();

        A = 0 + A;
        B = 0 + B;

        int length = A.length() > B.length() ? A.length() : B.length();

        dp1 = new int[2][length+1];
        dp2 = new int[2][length+1];

        res = LCS(0, A.length()-1, 0 , B.length()-1);

        sb.append(res.length()).append('\n');
        sb.append(res);

        System.out.println(sb);
    }
}
