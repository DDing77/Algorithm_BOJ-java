import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int[] numbers;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String input = br.readLine();

            int sum = 0;
            numbers = new int[input.length()];
            for (int i = 0; i < input.length(); i++) {
                numbers[i] = input.charAt(i) - '0';

                if (i % 2 == 0) {
                    int temp = numbers[i] * 2;
                    if (temp >= 10) {
                        numbers[i] = 0;
                        while (temp > 0) {
                            numbers[i] += temp % 10;
                            temp /= 10;
                        }
                    } else {
                        numbers[i] = temp;
                    }
                }

                sum += numbers[i];
            }

            if (sum % 10 == 0) {
                sb.append("T").append("\n");
            } else {
                sb.append("F").append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
