import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static char[] binary;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int res = 0;
        int cnt;
        while (true) {
            cnt = 0;
            binary = Integer.toBinaryString(N).toCharArray();
            for (int bi : binary) {
                if (bi == '1') cnt++;
            }

            if (cnt <= K) break;
            N++;
            res++;
        }

        System.out.println(res);
    }
}