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
    private int count;
    private int targetIdx;
    private int res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        numbers = new int[N + 2];
        numbers[0] = Integer.MIN_VALUE;
        numbers[N + 1] = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            if (numbers[i - 1] > numbers[i]) {
                targetIdx = i - 1;
                count++;
            }
        }

        if (count == 0) {
            res = N;
        } else if (count > 1) {
            res = 0;
        } else {
            if (numbers[targetIdx - 1] <= numbers[targetIdx + 1]) {
                res++;
            }
            if (numbers[targetIdx] <= numbers[targetIdx + 2]) {
                res++;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
