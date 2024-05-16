import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private String input;
    private boolean[] alphabet;

    private void solution() throws IOException {

        while (true) {
            input = br.readLine();

            if (input.equals("*")) {
                break;
            }

            alphabet = new boolean[26];

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == ' ') {
                    continue;
                }
                alphabet[input.charAt(i) - 'a'] = true;
            }

            boolean flag = true;
            for (int i = 0; i < alphabet.length; i++) {
                if (!alphabet[i]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                sb.append("Y").append("\n");
            } else {
                sb.append("N").append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
