import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static long N;
    static int[][] mat;
    static int[] res;
    static int[] temp1;
    static int[][] temp2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            mat = new int[][]{{3, 5}, {1, 3}};
            res = new int[]{1, 0};

            while (N > 0) {
                if ((N & 1) > 0) {
                    temp1 = new int[]{
                            mat[0][0] * res[0] + mat[0][1] * res[1],
                            mat[1][0] * res[0] + mat[1][1] * res[1]
                    };
                    res[0] = temp1[0] % 1000;
                    res[1] = temp1[1] % 1000;
                }
                temp2 = new int[][]{
                        {mat[0][0] * mat[0][0] + mat[0][1] * mat[1][0],
                                mat[0][0] * mat[0][1] + mat[0][1] * mat[1][1]},
                        {mat[1][0] * mat[0][0] + mat[1][1] * mat[1][0],
                                mat[1][0] * mat[0][1] + mat[1][1] * mat[1][1]}
                };

                mat[0][0] = temp2[0][0] % 1000;
                mat[0][1] = temp2[0][1] % 1000;
                mat[1][0] = temp2[1][0] % 1000;
                mat[1][1] = temp2[1][1] % 1000;

                N >>= 1;
            }

            int ans = (res[0] * 2 - 1) % 1000;
            if (ans < 10) sb.append("Case #").append(t).append(": 00").append(ans).append('\n');
            else if (ans < 100) sb.append("Case #").append(t).append(": 0").append(ans).append('\n');
            else sb.append("Case #").append(t).append(": ").append(ans).append('\n');
        }
        System.out.print(sb);
    }
}

