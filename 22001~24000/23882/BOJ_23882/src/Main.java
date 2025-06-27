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
            int maxValue = numbers[i];
            int maxIdx = i;
            int j;
            for (j = i; j >= 0; j--) {
                if (maxValue < numbers[j]) {
                    maxValue = numbers[j];
                    maxIdx = j;
                }
            }

            if (i != maxIdx) {
                swapCnt++;
                int temp = numbers[i];
                numbers[i] = numbers[maxIdx];
                numbers[maxIdx] = temp;
            }

            if (swapCnt == K) {
                for (int number : numbers) {
                    sb.append(number).append(" ");
                }
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
