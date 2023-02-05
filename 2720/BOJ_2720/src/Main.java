import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int T;
    static int input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input = Integer.parseInt(br.readLine());
            sb.append(input / 25 + " ");
            input -= (input / 25 * 25);
            sb.append(input / 10 + " ");
            input -= (input / 10 * 10);
            sb.append(input / 5 + " ");
            input -= (input / 5 * 5);
            sb.append(input / 1 + " ");
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
