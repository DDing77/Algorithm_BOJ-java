import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int S;
    int C;
    int[] onions;
    int left;
    int right;
    long sum;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        onions = new int[S];

        left = 1;
        right = Integer.MIN_VALUE;

        for (int i = 0; i < S; i++) {
            onions[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, onions[i]);
            sum += onions[i];
        }

        while (left <= right) {
            int mid = (left + right) >> 1;
            long cnt = 0;
            for (int onion : onions) {
                cnt += onion / mid;
            }

            if (cnt < C) {
                right = mid - 1;
            } else {
                left = mid + 1;
                res = mid;
            }
        }

//        System.out.println("left = " + left);
//        System.out.println("right = " + right);
        System.out.println(sum - (long) res * C);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
