import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;
    int[] numbers;
    int gcd;

    public int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        gcd = Math.abs(numbers[0] - numbers[1]);

        for (int i = 1; i < N - 1; i++) {
            gcd = getGCD(gcd, Math.abs(numbers[i] - numbers[i + 1]));
        }

        for (int i = 2; i <= gcd; i++) {
            if (gcd % i == 0) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
