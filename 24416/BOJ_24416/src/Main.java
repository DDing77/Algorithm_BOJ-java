import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int recurCnt;

    static void recursive(int n) {
        if (n == 1 || n == 2) {
            recurCnt++;
            return;
        }
        recursive(n - 1);
        recursive(n - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        recurCnt = 0;
        recursive(n);

        System.out.println(recurCnt + " " + (n - 2));

    }
}
