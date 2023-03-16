import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private long N;
    private long[] factorials;

    public void getFactorial(int size) {
        factorials = new long[size + 1];
        factorials[0] = 1;
        for (int i = 1; i <= size; i++) {
            factorials[i] = i * factorials[i - 1];
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());

        if (N == 0) {
            System.out.println("NO");
            return;
        }

        getFactorial(20);

        for (int i = 20; i >= 0; i--) {
            if (N >= factorials[i]) {
                N -= factorials[i];
            }
        }

        if (N == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
