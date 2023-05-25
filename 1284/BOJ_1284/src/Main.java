import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String input;
    static int res;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (!(input = br.readLine()).equals("0")) {
            res = 0;

            res += input.length() + 1;

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '1') {
                    res += 2;
                } else if (input.charAt(i) == '0') {
                    res += 4;
                } else {
                    res += 3;
                }
            }

            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
