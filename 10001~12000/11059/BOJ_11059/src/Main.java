import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    String input;
    int[] prefixSum;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        int length = input.length();
        res = length;

        prefixSum = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            prefixSum[i] = prefixSum[i - 1] + input.charAt(i - 1) - '0';
        }

        loop:
        for (int i = length; i >= 2; i--) {
            if (i % 2 != 0) {
                continue;
            }

            int leftSum;
            int rightSum;

            for (int j = 1; j <= length - i + 1; j++) {
                leftSum = prefixSum[j + (i / 2) - 1] - prefixSum[j - 1];
                rightSum = prefixSum[j + i - 1] - prefixSum[j + (i / 2) - 1];

                if (leftSum == rightSum) {

                    res = i;
                    break loop;
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
