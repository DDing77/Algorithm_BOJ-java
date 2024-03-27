import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int M;
    int[] numbers;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        int left = -1;
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, numbers[i]);
        }

        while (left + 1 < right) {
            int mid = (left + right) >> 1;

            int cnt = 1;
            int idx = 0;
            int min = 10_001;
            int max = 0;
            while (idx < N) {

                min = Math.min(min, numbers[idx]);
                max = Math.max(max, numbers[idx]);

                if (max - min > mid) {
                    cnt++;
                    min = numbers[idx];
                    max = numbers[idx];
                }
                idx++;
            }

            if (cnt <= M) {
                right = mid;
            } else {
                left = mid;
            }
        }

        System.out.println(right);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
