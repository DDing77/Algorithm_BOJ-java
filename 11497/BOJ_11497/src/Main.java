import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private int T, N;
    private int[] numbers;
    private int[] temp;
    private int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            numbers = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(numbers);

            int left = 0;
            int right = N - 1;

            temp = new int[N];
            for (int i = 0; i < N; i++) {
                if (i % 2 == 0) {
                    temp[left++] = numbers[i];
                } else {
                    temp[right--] = numbers[i];
                }
            }

            res = temp[N - 1] - temp[0];
            for (int i = 1; i < N; i++) {
                res = Math.max(res, Math.abs(temp[i] - temp[i - 1]));
            }

            sb.append(res).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
// 2 5 9
// 4 7