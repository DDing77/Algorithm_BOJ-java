import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        while (true) {
            input = br.readLine();
            if (input.equals("#")) {
                break;
            }

            int countOne = 0;
            for (int i = 0; i < input.length() - 1; i++) {
                if (input.charAt(i) == '1') {
                    countOne++;
                }
            }

            sb.append(input, 0, input.length() - 1);
            if (input.charAt(input.length() - 1) == 'e') {
                if (countOne % 2 == 0) {
                    sb.append(0);
                } else {
                    sb.append(1);
                }
            }

            if (input.charAt(input.length() - 1) == 'o') {
                if (countOne % 2 == 0) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
