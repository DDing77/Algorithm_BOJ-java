import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    static int N;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        res = 0;
        while (N-- > 0) {
            BigInteger temp = new BigInteger(br.readLine());
            BigInteger mul = new BigInteger("2");
            BigInteger add = new BigInteger("1");
            temp = temp.multiply(mul);
            temp = temp.add(add);
            if (temp.isProbablePrime(10)) res++;
//            System.out.println(temp);

        }
        System.out.println(res);
    }
}
