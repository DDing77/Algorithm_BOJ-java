import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] numbers;
    static int res;

    public static void backTracking(int value, int depth) {
        res = Math.max(res, value);

        for (int i = 0; i < K; i++) {
            if (value * 10 + numbers[i] > N) continue;
            System.out.println(value * 10 + numbers[i]);
            backTracking(value * 10 + numbers[i], depth + 1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        numbers = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        res = 0;
        backTracking(0, 0);

        System.out.println(res);
    }
}
