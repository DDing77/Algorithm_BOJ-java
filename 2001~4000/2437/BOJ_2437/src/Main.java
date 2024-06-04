import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] weights;
    private int preSum;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        weights = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weights);

        preSum = 0;
        for (int i = 0; i < N; i++) {
            if (preSum + 1 < weights[i]) {
                break;
            }
            preSum += weights[i];
        }

        System.out.println(preSum + 1);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
