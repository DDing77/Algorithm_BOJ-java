import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private int a, b;
    private boolean[] primes;

    public String getResult() {
        StringBuilder sb = new StringBuilder();
        primes = new boolean[b + 1];
        primes[0] = true;
        primes[1] = true;

        for (int i = 2; i <= b; i++) {
            if (!primes[i]) {
                for (int j = i * 2; j <= b; j += i) {
                    primes[j] = true;
                }
                if (i >= a && i <= b && isPalindrome(i)) {
                    sb.append(i).append('\n');
                }
            }
        }
        sb.append(-1);

        return sb.toString();
    }

    public boolean isPalindrome(int number) {
        String str = String.valueOf(number);

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        if (b > 10_000_000) {
            b = 10_000_000;
        }

        System.out.println(getResult());
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
