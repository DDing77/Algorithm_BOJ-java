import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static int[] deliciousValue;
    static int res;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        deliciousValue = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            deliciousValue[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = K - 1;
        int sum = 0;
        for (int i = 0; i <= K - 1; i++) {
            sum += deliciousValue[i];
        }

        res = sum;
        while (true) {
            sum -= deliciousValue[left];
            left = (left + 1) % N;
            right = (right + 1) % N;
            sum += deliciousValue[right];

            if (left == 0) {
                break;
            }

            res = Math.max(res, sum);
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
