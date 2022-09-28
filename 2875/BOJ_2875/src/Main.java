import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int res = N / 2 > M ? M : N / 2;

        int remain = (N - res * 2) + (M - res);

        if( remain >= K ) System.out.println(res);
        else {
            K -= remain;
            res -= K / 3;
            if (K % 3 > 0) res--;
            System.out.println(res);
        }
    }
}
