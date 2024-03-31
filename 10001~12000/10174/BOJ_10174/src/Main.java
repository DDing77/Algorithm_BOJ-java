import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int N;
    String input;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            input = input.toLowerCase();
            boolean isPalindrome = true;
            for (int j = 0; j < input.length() / 2; j++) {
                if (input.charAt(j) != input.charAt(input.length() - j - 1)) {
                    sb.append("No").append("\n");
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) {
                sb.append("Yes").append("\n");
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
