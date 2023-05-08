import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private final int MAX_LENGTH = 10_000 * 10_000;
    private final String[] messages = {"Shortest primed subsequence is length ", "This sequence is anti-primed."};
    private int t;
    private int n;
    private int[] sum;
    private boolean[] prime;

    public void makePrime() {
        prime = new boolean[MAX_LENGTH + 1];
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(MAX_LENGTH); i++) {
            if (!prime[i]) {
                for (int j = i * 2; j <= MAX_LENGTH; j += i) {
                    prime[j] = true;
                }
            }
        }
    }

    public boolean isPrime(int num) {
        if (num % 2 == 0 && num != 2 || num == 1)
            return false;

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

//        makePrime();

        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            sum = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                sum[i] += sum[i - 1] + Integer.parseInt(st.nextToken());
            }

            int curLength = 2;
            int tempSum;
            boolean isFind = false;

            while (!isFind && curLength <= n) {
                for (int start = 1; start + curLength - 1 <= n; start++) {
                    tempSum = sum[start + curLength - 1] - sum[start - 1];
                    if (isPrime(tempSum) && tempSum >= 2) {
                        sb.append(messages[0]).append(curLength).append(": ");

                        while (curLength > 0) {
                            sb.append((sum[start] - sum[start - 1]) + " ");
                            start++;
                            curLength--;
                        }
                        sb.append('\n');

                        isFind = true;
                        break;
                    }
                }
                curLength++;
            }

            if (!isFind) {
                sb.append(messages[1]).append('\n');
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
