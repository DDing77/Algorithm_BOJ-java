import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private String input;

    private void solution() throws IOException {
        input = br.readLine();

        int pre = 0;
        int length = input.length();
        int range = Math.min(3, length);

        for (int i = 0; i < range; i++) {
            pre = pre * 10;
            pre += input.charAt(i) - '0';

            StringBuilder addingString = new StringBuilder();

            for (int nextNum = pre; ; nextNum++) {
                addingString.append(nextNum);
                if (addingString.length() == length && addingString.toString().equals(input)) {
                    sb.append(pre).append(' ').append(nextNum);
                    System.out.print(sb);
                    return;
                }
                if (addingString.length() > length) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
