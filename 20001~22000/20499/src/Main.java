import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String[] c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        c = br.readLine().split("/");

        int K = Integer.parseInt(c[0]);
        int D = Integer.parseInt(c[1]);
        int A = Integer.parseInt(c[2]);

        int res = K + A;

        if (res < D || D == 0) System.out.println("hasu");
        else System.out.println("gosu");
    }
}