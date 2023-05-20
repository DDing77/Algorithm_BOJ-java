import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final String[] message = {"odd", "even"};
    static int N;
    static String input;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            input = br.readLine();
            if (Integer.parseInt(input.substring(input.length() - 1)) % 2 == 0) {
                sb.append(message[1]);
            } else {
                sb.append(message[0]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
