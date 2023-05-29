import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = M; i <= N; i++) {
            if (i % Math.sqrt(i) == 0) {
                sum += i;
                res = Math.min(res, i);
            }
        }

        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(res);
        }
    }
}