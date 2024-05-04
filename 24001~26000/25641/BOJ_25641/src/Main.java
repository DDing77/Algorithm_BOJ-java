import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private String input;
    private int[][] prefixSum;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        input = br.readLine();

        prefixSum = new int[N + 1][2];
        for (int i = N - 1; i >= 0; i--) {
            prefixSum[i][0] = prefixSum[i + 1][0];
            prefixSum[i][1] = prefixSum[i + 1][1];

            char cur = input.charAt(i);
            if (cur == 's') {
                prefixSum[i][0]++;
            } else if (cur == 't') {
                prefixSum[i][1]++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (prefixSum[i][0] == prefixSum[i][1]) {
                System.out.println(input.substring(i));
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
