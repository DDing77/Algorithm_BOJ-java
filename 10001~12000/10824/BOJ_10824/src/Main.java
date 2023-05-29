import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static String[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numbers = br.readLine().split(" ");

        String a = numbers[0] + numbers[1];
        String b = numbers[2] + numbers[3];

        BigInteger res = new BigInteger(a);
        res = res.add(BigInteger.valueOf(Long.parseLong(b)));
        System.out.println(res);
    }
}

