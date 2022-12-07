import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            input = br.readLine();
            if (6 <= input.length() && input.length() <= 9) {
                sb.append("yes").append('\n');
                continue;
            }
            sb.append("no").append('\n');
        }
        System.out.print(sb);
    }
}
