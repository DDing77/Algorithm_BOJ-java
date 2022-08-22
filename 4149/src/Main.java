import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static BigInteger n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         n = new BigInteger(br.readLine());

         boolean flag = n.isProbablePrime(10);

         if(!flag) System.out.println("Not");
         else System.out.println("Yes");
    }
}
