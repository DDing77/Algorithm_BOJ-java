import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] numbers;
    private int res;

    private int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String[] input = br.readLine().split(" ");
            numbers = new int[input.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(input[i]);
            }

            res = 0;
            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    res = Math.max(res, getGCD(numbers[i], numbers[j]));
                }
            }

            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
