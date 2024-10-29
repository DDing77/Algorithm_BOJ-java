import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int K;
    private int[] numbers;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int swapCnt = 0;
        for (int i = N - 1; i > 0; i--) {
            int maxIdx = i;
            int max = numbers[i];
            for (int j = i - 1; j >= 0; j--) {
                if (max < numbers[j]) {
                    maxIdx = j;
                    max = numbers[j];
                }
            }

            if (maxIdx != i) {
                swapCnt++;
                int tmp = numbers[i];
                numbers[i] = numbers[maxIdx];
                numbers[maxIdx] = tmp;
            }

            if (swapCnt == K) {
                sb.append(numbers[maxIdx]).append(" ").append(numbers[i]);
                System.out.println(sb);
                return;
            }
        }

        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
