import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int even(String input) {
        int cnt = 0;
        for (int i = 1; i < input.length(); i += 2) {
            if (input.charAt(i) == 'F') cnt++;
        }
        return cnt;
    }

    static int odd(String input) {
        int cnt = 0;
        for (int i = 0; i < input.length(); i += 2) {
            if (input.charAt(i) == 'F') cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int res = 0;
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) res += odd(br.readLine());
            else res += even(br.readLine());
        }

        System.out.println(res);
    }
}