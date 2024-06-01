import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private int[] digits;
    private boolean[] isSelected;
    private int res;

    private void backTracking(int depth, int sum) {
        if (depth == digits.length) {
            if (N < sum && sum < res) {
                res = sum;
            }
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (!isSelected[i]) {
                int nextSum = sum * 10 + digits[i];
                if (nextSum < res) {
                    isSelected[i] = true;
                    backTracking(depth + 1, nextSum);
                    isSelected[i] = false;
                }
            }

        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        digits = new int[(int)Math.log10(N) + 1];
        isSelected = new boolean[digits.length];

        int temp = N;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        res = Integer.MAX_VALUE;
        backTracking(0, 0);

        if (res == Integer.MAX_VALUE) {
            System.out.println(0);
            return;
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
