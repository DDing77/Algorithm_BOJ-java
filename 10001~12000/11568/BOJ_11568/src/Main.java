import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] lis;

    private int binarySearch(int lastIdx, int value) {
        int left = -1;
        int right = lastIdx;

        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (lis[mid] >= value) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return right;
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        lis = new int[N];
        int right = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (right == 0) {
                lis[right++] = value;
            } else {
                if (lis[right - 1] < value) {
                    lis[right++] = value;
                } else {
                    lis[binarySearch(right - 1, value)] = value;
                }
            }
        }
        System.out.println(right);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
