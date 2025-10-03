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
    private int S;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        S = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int max = numbers[i];
            int idx = -1;
            for (int j = i + 1; j <= i + S && j < N; j++) {
                if (max < numbers[j]) {
                    max = numbers[j];
                    idx = j;
                }
            }

            if (idx != -1) {
                S -= idx - i;
                for (int j = idx; j > i; j--) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = temp;
                }
            }

            if (S <= 0) {
                break;
            }
        }

        for (int number : numbers) {
            sb.append(number).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
