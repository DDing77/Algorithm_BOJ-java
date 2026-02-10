import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int T;
    private char[] input;
    private int[] cntArr;

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input = br.readLine().toCharArray();

            int idx = input.length - 2;
            cntArr = new int[10];
            while (idx >= 0) {
                cntArr[input[idx + 1] - '0']++;
                if (input[idx] < input[idx + 1]) {
                    cntArr[input[idx] - '0']++;
                    break;
                }
                idx--;
            }

            if (idx == -1) {
                sb.append("BIGGEST").append("\n");
                continue;
            }

            for (int i = 0; i < idx; i++) {
                sb.append(input[i]);
            }

            for (int i = (input[idx] - '0') + 1; i < 10; i++) {
                if (cntArr[i] > 0) {
                    sb.append(i);
                    cntArr[i]--;
                    break;
                }
            }

            for (int i = 0; i < 10; i++) {
                while (cntArr[i] > 0) {
                    sb.append(i);
                    cntArr[i]--;
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
