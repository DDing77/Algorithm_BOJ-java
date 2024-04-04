import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int Q;
    int[] haybales;

    private int upperBound(int target) {

        int left = -1;
        int right = N;
        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (haybales[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return right;
    }

    private int lowerBound(int target) {

        int left = -1;
        int right = N;
        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (haybales[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return right;
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        haybales = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            haybales[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(haybales);

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int targetA = Integer.parseInt(st.nextToken());
            int targetB = Integer.parseInt(st.nextToken());
            sb.append(upperBound(targetB) - lowerBound(targetA)).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
