import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        BigDecimal one = new BigDecimal(1);
        BigDecimal denominator = BigDecimal.valueOf(2).pow(N);

        BigDecimal result = one.divide(denominator, new MathContext(300, RoundingMode.HALF_UP));

        result = result.stripTrailingZeros();

        if (result.toPlainString().startsWith(".")) {
            System.out.println("0" + result.toPlainString());
        } else {
            System.out.println(result.toPlainString());
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
