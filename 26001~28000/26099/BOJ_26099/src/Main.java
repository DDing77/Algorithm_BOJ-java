import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private void solution() throws IOException {
        long n = Long.parseLong(br.readLine());

        long maxFiveCount = n / 5;
        long targetRemainder = (2 * (n % 3)) % 3;

        long diff = (maxFiveCount % 3 - targetRemainder + 3) % 3;
        long fiveCount = maxFiveCount - diff;

        if (fiveCount < 0) {
            System.out.println(-1);
            return;
        }

        long remain = n - fiveCount * 5;

        if (remain < 0 || remain % 3 != 0) {
            System.out.println(-1);
            return;
        }

        long threeCount = remain / 3;
        System.out.println(fiveCount + threeCount);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}