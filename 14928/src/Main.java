import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // TL
//        BigInteger input = new BigInteger(br.readLine());
//
//        System.out.println(input.remainder(BigInteger.valueOf(20000303)));

        String N = br.readLine();
        long remain = 0;
        for (int i = 0; i < N.length(); i++) {
            remain = (remain * 10 + (N.charAt(i) - '0')) % 20000303;
//            System.out.println("test : " + remain);
        }
        System.out.println(remain);
    }
}
