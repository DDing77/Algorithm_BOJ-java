import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main {

    static int Gold_Chicken(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        int a = 1, b = 1;
        while (true) {
            int c = a + b;
            if (c > x) return a + Gold_Chicken(x - b);
            else if (c == x) return b;
            a = b;
            b = c;
        }
    }

    ;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int human = Integer.parseInt(n);

        System.out.println(Gold_Chicken(human));
    }
}
