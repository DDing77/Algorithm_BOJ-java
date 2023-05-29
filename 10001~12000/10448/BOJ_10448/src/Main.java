import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] eu;

    public static boolean eureka(int input) {
        for (int a = 1; a < 45; a++) {
            for (int b = 1; b < 45; b++) {
                for (int c = 1; c < 45; c++) {
                    if (eu[a] + eu[b] + eu[c] == input) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        eu = new int[45];

        for (int i = 1; i < 45; i++) {
            eu[i] = i * (i + 1) / 2;
        }


        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            if (!eureka(Integer.parseInt(br.readLine()))) {
                sb.append("0");
            } else {
                sb.append("1");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
