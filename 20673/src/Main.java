import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int p;
    static int q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        p = Integer.parseInt(br.readLine());
        q = Integer.parseInt(br.readLine());

        if (p <= 50 && q <= 10) System.out.println("White");
        else if (q > 30) System.out.println("Red");
        else System.out.println("Yellow");
    }
}