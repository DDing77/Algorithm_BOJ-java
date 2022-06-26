import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int S, A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = Integer.parseInt(br.readLine());
        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());

        if (S > A) {
            int gap = S - A;
            int res;

            if (gap % B == 0) res = gap / B;
            else res = gap / B + 1;

            System.out.println(res * 100 + 250);
        } else System.out.println(250);
    }
}