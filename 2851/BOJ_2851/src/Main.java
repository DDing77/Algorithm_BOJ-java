import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int diff = 100;
        int sum = 0;
        res = -1;

        for (int i = 0; i < 10; i++) {
            sum += Integer.parseInt(br.readLine());

            if (Math.abs(100 - sum) <= diff) {
                diff = Math.abs(100 - sum);
                res = sum;
            }
        }

        System.out.println(res);
    }
}
