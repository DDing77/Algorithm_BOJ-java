import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] budget;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        budget = new int[N];

        int left = 0;
        int right = 0;
        int mid;
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, budget[i]);
            sum += budget[i];
        }

        M = Integer.parseInt(br.readLine());

        if (sum <= M) {
            System.out.println(right);
            return;
        }

        while (left <= right) {
            mid = (left + right) >> 1;
            int temp = 0;

            for (int value : budget) {
                if (value > mid) {
                    temp += mid;
                } else {
                    temp += value;
                }
            }

            if (temp > M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right);
    }
}
