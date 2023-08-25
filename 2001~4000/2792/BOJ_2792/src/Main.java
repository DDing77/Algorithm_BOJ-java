import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    int M;
    int[] jewel;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        jewel = new int[M];

        int left = 1;
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            jewel[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, jewel[i]);
        }

        res = 0;
        int cnt;
        while (left <= right) {
            int mid = (left + right) >> 1;
            cnt = 0;

            for (int i = 0; i < M; i++) {
                if (jewel[i] % mid == 0) {
                    cnt += jewel[i] / mid;
                } else {
                    cnt += jewel[i] / mid + 1;
                }
            }

            if (N >= cnt) {
                right = mid;
                res = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
