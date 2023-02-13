import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] times;
    static int totalTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        times = new int[N];
        totalTime = 0;
        int left = 0;

        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(br.readLine());
            totalTime += times[i];
            left = Math.max(left, times[i]);
        }

        int right = totalTime;
        int mid;

        while (left <= right) {
            mid = (left + right) >> 1;
            int cnt = 0;
            int temp = 0;
            int idx = 0;

            while (idx < N) {
                temp += times[idx];
                if (temp > mid) {
                    cnt++;
                    temp = times[idx];
                }
                idx++;
            }

            if (temp != 0) cnt++;

            if (cnt <= M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}

