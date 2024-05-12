import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        if (N < 3) {
            System.out.println(1);
            return;
        }

        BigInteger pre2 = new BigInteger("1");
        BigInteger pre1 = new BigInteger("1");
        BigInteger cur = null;
        for (int i = 3; i <= N; i++) {
            cur = pre2.add(pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        System.out.println(cur);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
