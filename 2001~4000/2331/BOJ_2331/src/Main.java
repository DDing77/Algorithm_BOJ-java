import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int P;
    static BigInteger A;
    static ArrayList<BigInteger> list;

    static BigInteger calculator(BigInteger number) {
        String temp = number.toString();
        BigInteger res = new BigInteger("0");
        for (int i = 0; i < temp.length(); i++) {
            BigInteger temp2 = new BigInteger("1");
//            System.out.println(temp.charAt(i));
            for (int j = 0; j < P; j++) {
//                System.out.println("temp2 = " + temp2);
                temp2 = temp2.multiply(BigInteger.valueOf(Long.parseLong(String.valueOf(temp.charAt(i)))));
//                System.out.println("temp2 = " + temp2);
            }
//            System.out.println("temp2 = " + temp2);
            res = res.add(temp2);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = new BigInteger(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        list.add(A);
        int res = 0;
        while (true) {
            BigInteger temp = calculator(A);
//            System.out.println("temp = " + temp);
            if (!list.contains(temp)) {
                list.add(temp);
                A = temp;
            } else {
                res = list.indexOf(temp);
                break;
            }
        }

        System.out.println(res);
    }
}
