import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int N;
    private int[] waters;
    private int res;

    public void twoPointer(int idx) {
        int left = idx + 1;
        int right = N - 1;
        int mid;
        int sum;
        while (left <= right) {
            mid = left + right >> 1;
            sum = waters[idx] + waters[mid];

            if (sum == 0) {
                res = 0;
                return;
            }
            if (Math.abs(res) > Math.abs(sum)) {
                res = sum;
            }

            if (sum < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        waters = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            waters[i] = Integer.parseInt(st.nextToken());
        }

        res = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            twoPointer(i);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
