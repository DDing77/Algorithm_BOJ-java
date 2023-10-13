import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    BigInteger a;
    BigInteger b;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = new BigInteger(br.readLine());
        b = new BigInteger(br.readLine());

        System.out.println(a.add(b));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
