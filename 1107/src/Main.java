import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int min;
    static boolean[] error;

    static int possible(int x) {
        int len = 0;

        if (x == 0) {
            if (error[0]) return 0;
            else return 1;
        }

        while (x > 0) {
            if (error[x % 10]) return 0;
            len += 1;
            x /= 10;
        }
        return len;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());


        min = Math.abs(N - 100);

        error = new boolean[10];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) error[Integer.parseInt(st.nextToken())] = true;

        for (int i = 0; i < 1000000; i++) {
            int len = possible(i);

            if (len > 0) {
                int plusCnt = Math.abs(i - N);

                if (min > len + plusCnt) min = len + plusCnt;
            }
        }
        System.out.println(min);
    }
}
