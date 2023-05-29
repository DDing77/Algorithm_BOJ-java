import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = N; i >= 4; i--) {
            boolean flag = true;
            int num = i;
            while (num != 0) {
                if (num % 10 == 4 || num % 10 == 7)
                    num /= 10;
                else {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println(i);
                break;
            }
        }
    }
}
