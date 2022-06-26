import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int b, p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        b = Integer.parseInt(br.readLine());
        p = 5 * b - 400;

        if (p < 100) {
            System.out.println(p);
            System.out.println(1);
        } else if (p > 100) {
            System.out.println(p);
            System.out.println(-1);
        } else {
            System.out.println(p);
            System.out.println(0);
        }
    }
}