import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N * 2; i++) {
            // 홀수줄
            if (i % 2 != 0) {
                for (int j = 1; j <= N; j++) {
                    if (j % 2 != 0) sb.append('*');
                    else sb.append(" ");
                }
            } else { // 짝수 줄
                for (int j = 1; j <= N; j++) {
                    if (j % 2 != 0) sb.append(" ");
                    else sb.append("*");
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}