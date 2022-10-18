import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()) - 1;

        BigDecimal pre = new BigDecimal(br.readLine());
        BigDecimal max = pre;

        while (N-- > 0) {
            BigDecimal cur = new BigDecimal(br.readLine());
            if (pre.compareTo(BigDecimal.ONE) > 0) pre = pre.multiply(cur);
            else pre = cur;

            if (max.compareTo(pre) < 0) max = pre;
        }

        System.out.println(max.setScale(3, RoundingMode.HALF_DOWN));
    }
}
