import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        BigInteger A = new BigInteger(br.readLine());
        BigInteger B= new BigInteger(br.readLine());

        sb.append(A.add(B)).append('\n');
        sb.append(A.subtract(B)).append('\n');
        sb.append(A.multiply(B));
        System.out.println(sb);
    }
}
