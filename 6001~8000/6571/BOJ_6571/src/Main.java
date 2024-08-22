import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int a;
    private int b;
    private int res;

    private void solution() throws IOException {

        while (true) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            if (a.equals("0") && b.equals("0")) {
                break;
            }

            BigInteger x = new BigInteger("0");
            BigInteger y = new BigInteger("1");
            BigInteger z;

            res = 0;
            BigInteger atoBI = new BigInteger(a);
            BigInteger btoBI = new BigInteger(b);
            while (true) {
                z = x.add(y);
                if (z.compareTo(btoBI) > 0) {
                    break;
                }

                if (z.compareTo(atoBI) >= 0) {
                    res++;
                }

                x = y;
                y = z;
            }

            sb.append(res).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
