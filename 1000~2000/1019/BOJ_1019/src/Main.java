import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int SIZE = 10;
    int N;
    int[] cnt;
    int digit;

    public void count(int digit, int number) {
        while (number > 0) {
            cnt[number % 10] += digit;
            number /= 10;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        cnt = new int[SIZE];

        N = Integer.parseInt(br.readLine());
        int start = 1;
        digit = 1;

        while (start <= N) {
            while (start <= N && start % 10 != 0) {
                count(digit, start);
                start++;
            }

            while (start <= N && N % 10 != 9) {
                count(digit, N);
                N--;
            }

            if (start > N) {
                break;
            }

            start /= 10;
            N /= 10;

            for (int i = 0; i < SIZE; i++) {
                cnt[i] += (N - start + 1) * digit;
            }

            digit *= 10;
        }

        for (int i = 0; i < SIZE; i++) {
            sb.append(cnt[i] + " ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
