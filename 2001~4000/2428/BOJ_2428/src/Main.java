import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int[] files;
    long res;

    private int getCount(int start) {
        int left = start;
        int right = N;

        while (left < right) {
            int mid = (left + right) >> 1;
            if (files[mid] * 9 <= 10 * files[start]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right - start - 1;
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        files = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            files[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(files);

        res = 0L;
        for (int i = 0; i < N - 1; i++) {
            res += getCount(i);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
