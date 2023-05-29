import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private int N;
    private StringBuilder sb;

    public boolean isPrime(int num) {
        if (num == 0 || num == 1) {
            return false;
        }

        int cnt = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void backTracking(int depth, int num) {
        if (depth == N) {
            if (isPrime(num)) {
                sb.append(num).append('\n');
                return;
            }
        }

        for (int i = 1; i <= 9; i++) {
            if (isPrime(num * 10 + i)) {
                backTracking(depth + 1, num * 10 + i);
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        backTracking(0, 0);

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
