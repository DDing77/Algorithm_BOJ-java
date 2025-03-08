import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private long[] numbers;

    private int greaterThan(long value) {
        int left = -1;
        int right = N;
        while (left + 1 < right) {
            int mid = (left + right) >> 1;

            if (numbers[mid] > value) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return N - right;
    }

    private int greaterEqualThan(long value) {
        int left = -1;
        int right = N;
        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (numbers[mid] >= value) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return N - right;
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(numbers);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            long value1 = Long.parseLong(st.nextToken());

            if (query == 1) {
                sb.append(greaterEqualThan(value1));
            } else if (query == 2) {
                sb.append(greaterThan(value1));
            } else if (query == 3) {
                 long value2 = Long.parseLong(st.nextToken());
                sb.append(greaterEqualThan(value1) - greaterThan(value2));
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
