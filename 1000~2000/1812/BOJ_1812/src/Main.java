import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private int[] sumArr;
    private int[] res;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        sumArr = new int[N];
        for (int i = 0; i < N; i++) {
            sumArr[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                sum += sumArr[i];
            } else {
                sum -= sumArr[i];
            }
        }

        res = new int[N];
        res[0] = sum / 2;
        for (int i = 1; i < N; i++) {
            res[i] = sumArr[i - 1] - res[i - 1];
        }

        for (int value : res) {
            sb.append(value).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
