import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    String input;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            input = br.readLine();
            if (input.equals("0")) {
                break;
            }

            int fac = 1;
            res = 0;
            for (int i = 1; i <= input.length(); i++) {
                fac *= i;
                res += fac * (input.charAt(input.length() - i) - '0');
            }

            sb.append(res).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
