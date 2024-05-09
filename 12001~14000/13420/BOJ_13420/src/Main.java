import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    String[] input;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input = br.readLine().split(" ");

            long result = 0;
            if (input[1].equals("+")) {
                result = Long.parseLong(input[0]) + Long.parseLong(input[2]);
            } else if (input[1].equals("-")) {
                result = Long.parseLong(input[0]) - Long.parseLong(input[2]);
            } else if (input[1].equals("*")) {
                result = Long.parseLong(input[0]) * Long.parseLong(input[2]);
            } else if (input[1].equals("/")) {
                result = Long.parseLong(input[0]) / Long.parseLong(input[2]);
            }

            if (Long.parseLong(input[4]) == result) {
                sb.append("correct");
            } else {
                sb.append("wrong answer");
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
