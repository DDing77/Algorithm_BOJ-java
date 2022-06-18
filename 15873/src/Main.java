import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n >= 1000) {
            a = n / 100;
            b = n % 100;
        } else if (n >= 100) {
            a = n / 10;
            if (a > 10) {
                a = n / 100;
                b = n % 100;
            } else {
                b = n % 10;
            }
        } else {
            a = n / 10;
            b = n % 10;
        }


        System.out.println(a + b);
    }
}