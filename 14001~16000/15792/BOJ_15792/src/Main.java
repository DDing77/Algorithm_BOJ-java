import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {

    static BigDecimal a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new BigDecimal(Integer.parseInt(st.nextToken()));
        b = new BigDecimal(Integer.parseInt(st.nextToken()));

        System.out.println(a.divide(b, 1000, BigDecimal.ROUND_HALF_UP));
    }
}
