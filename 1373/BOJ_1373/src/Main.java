import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String input;
    static StringBuilder sb;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        input = br.readLine();
        if (input.length() % 3 == 1) {
            input = "00" + input;
        }
        if (input.length() % 3 == 2) {
            input = "0" + input;
        }

        int a = 0;
        int b = 0;
        int c = 0;
        int cur;
        for (int i = input.length() - 1; i >= 0; i--) {
            cur = input.charAt(i) - '0';
            if (i % 3 == 0) {
                a = cur * 4;
                sb.append(a + b + c);
            }
            if (i % 3 == 1) {
                b = cur * 2;
            }
            if (i % 3 == 2) {
                c = cur;
            }
        }

        System.out.println(sb.reverse());
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
