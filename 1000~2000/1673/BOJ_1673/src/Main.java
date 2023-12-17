import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    int K;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String input;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            res = 0;
            int temp = N;
            int couponCnt = 0;
            while (temp >= K) {
                couponCnt += N / K;
                temp = temp / K + temp % K;
            }
            sb.append(N + couponCnt).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
