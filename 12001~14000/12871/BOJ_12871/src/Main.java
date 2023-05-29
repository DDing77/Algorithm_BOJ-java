import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String a, b;

    public static int getGCD(int a, int b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = br.readLine();
        b = br.readLine();

        int lengthA = a.length();
        int lengthB = b.length();

        int lcm = (lengthA / getGCD(lengthA, lengthB)) * lengthB;
        String tempA = a;
        String tempB = b;

        while (tempA.length() < lcm) {
            tempA += a;
        }

        while (tempB.length() < lcm) {
            tempB += b;
        }

        if (tempA.equals(tempB)) System.out.println("1");
        else System.out.println("0");
    }
}
