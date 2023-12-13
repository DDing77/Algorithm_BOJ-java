import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    int K;
    int[] kettles;

    private int getCount(long mid) {
        int cnt = 0;
        for (int kettle : kettles) {
            cnt += kettle / mid;
        }
        return cnt;
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        kettles = new int[N];
        long left = 1;
        long right = 0;
        for (int i = 0; i < N; i++) {
            kettles[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, kettles[i]);
        }

        int cnt = 0;
        long mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            cnt = getCount(mid);

            if (cnt < K) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
