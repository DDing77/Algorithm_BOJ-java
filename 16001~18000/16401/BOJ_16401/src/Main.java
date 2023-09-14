import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    int M;
    int N;
    int[] candies;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        candies = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            candies[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(candies);

        res = 0;
        int left = 1;
        int right = candies[N - 1];
        int mid;
        boolean isOk = false;
        while (left < right) {
            mid = left + right >> 1;
            int cnt = 0;
            isOk = false;

            for (int i = 0; i < N; i++) {
                cnt += (candies[i] / mid);
                if (cnt >= M) {
                    res = Math.max(res, mid);
                    left = mid;
                    isOk = true;
                    break;
                }
            }

            if (!isOk) {
                right = mid - 1;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
