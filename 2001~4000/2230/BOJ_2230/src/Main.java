import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private int N, M;
    private int[] numbers;
    private int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        int left = 0;
        int right = N;
        int mid;
        res = numbers[right - 1] - numbers[left];
        for (int i = 0; i < N; i++) {
            left = i;
            right = N;

            out:
            while (left < right) {
                mid = left + right >> 1;
                if (numbers[mid] - numbers[i] == M) {
                    res = numbers[mid] - numbers[i];
                    break out;
                } else if (numbers[mid] - numbers[i] > M) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            if (right == N) {
                continue;
            }

            res = Math.min(res, numbers[right] - numbers[i]);

            if (res == M) {
                break;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
