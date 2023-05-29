import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int sum = 0;
        res = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == b && b == c) sum = 10000 + a * 1000;
            else if (a == b) sum = 1000 + a * 100;
            else if (b == c) sum = 1000 + b * 100;
            else if (c == a) sum = 1000 + c * 100;
            else sum = Math.max(a, Math.max(b, c)) * 100;

            res = Math.max(res, sum);
        }

        System.out.println(res);
    }
}
