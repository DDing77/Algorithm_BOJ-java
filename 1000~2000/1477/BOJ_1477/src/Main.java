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
    int M;
    int L;
    int[] arr;

    private boolean check(int mid) {
        int cnt = 0;

        for (int i = 1; i < arr.length; i++) {
            cnt += (arr[i] - arr[i - 1] - 1) / mid;
        }
        return cnt <= M;
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[N + 2];
        arr[0] = 0;
        arr[1] = L;
        st = new StringTokenizer(br.readLine());
        for (int i = 2; i < N + 2; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = L;

        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (check(mid)) {
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
