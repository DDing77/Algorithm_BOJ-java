import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int L;
    int K;
    int C;
    int[] splits;
    int firstCutIdx;

    private int check(int mid) {

        int left = K;
        int right = K;
        int cutCount = 0;
        while (left > 0 && cutCount < C) {
            left--;
            if (splits[right] - splits[left] > mid) {
                if (right - left == 1) {
                    return -1;
                }

                cutCount++;
                left++;
                right = left;
            }
        }

        if (splits[left] > mid || splits[right] - splits[left] > mid) {
            return -1;
        }

        return splits[left];
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = L;

        splits = new int[K + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            splits[i] = Integer.parseInt(st.nextToken());
        }

        splits[K] = L;
        Arrays.sort(splits);

        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            int res = check(mid);
            if (res == -1) {
                left = mid;
            } else {
                right = mid;
                firstCutIdx = res;
            }
        }

        sb.append(right).append(" ").append(firstCutIdx);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}

