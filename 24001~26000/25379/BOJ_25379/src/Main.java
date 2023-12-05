import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    long leftSum;
    long rightSum;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        leftSum = 0L;
        rightSum = 0L;
        int idx = 0;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur % 2 == 0) {
                leftSum += i - idx;
                rightSum += N - i - 1 - idx;
                idx++;
            }
        }
        System.out.println(Math.min(leftSum, rightSum));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
