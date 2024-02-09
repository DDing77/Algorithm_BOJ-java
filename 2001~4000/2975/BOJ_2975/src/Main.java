import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    String input;

    private void solution() throws IOException {

        while (true) {
            input = br.readLine();

            if (input.equals("0 W 0")) {
                break;
            }

            st = new StringTokenizer(input);

            int startBalance = Integer.parseInt(st.nextToken());
            String op = st.nextToken();
            int amount = Integer.parseInt(st.nextToken());

            if (op.equals("D")) {
                startBalance += amount;
            } else {
                startBalance -= amount;
            }

            if (startBalance < -200) {
                sb.append("Not allowed");
            } else {
                sb.append(startBalance);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}

