import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private int n;
    private long[] leftSum;
    private long[] rightSum;
    private int[] cross;
    private int resIdx;
    private long resMin;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        cross = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cross[i] = Integer.parseInt(st.nextToken());
        }

        leftSum = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            leftSum[i] += leftSum[i - 1] + Integer.parseInt(st.nextToken());
        }

        rightSum = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            rightSum[i] += rightSum[i - 1] + Integer.parseInt(st.nextToken());
        }

        resIdx = -1;
        resMin = Long.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            if (resMin > cross[i] + (leftSum[i]) + (rightSum[n] - rightSum[i])) {
                resMin = cross[i] + (leftSum[i]) + (rightSum[n] - rightSum[i]);
                resIdx = i;
            }
        }

        System.out.println(resIdx + " " + resMin);
    }


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
