import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int num;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        res = 0;

        while (true) {
            num = Integer.parseInt(br.readLine());
            if (num == -1) break;
            res += num;
        }

        System.out.println(res);
    }
}
