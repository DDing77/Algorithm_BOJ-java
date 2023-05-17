import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MAX_LENGTH = 1_000_000;
    static int T;
    static long[] prefixSum;

    public void makePrefixSum() {
        prefixSum = new long[MAX_LENGTH + 1];

        int mul;
        for (int i = 1; i <= MAX_LENGTH; i++) {
            prefixSum[i] += prefixSum[i - 1];
            mul = 1;

            while (i * mul <= MAX_LENGTH) {
                prefixSum[i * mul] += i;
                mul++;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        makePrefixSum();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            sb.append(prefixSum[Integer.parseInt(br.readLine())]).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
