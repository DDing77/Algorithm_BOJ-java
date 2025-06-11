import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private char[] word;

    private void solution() throws IOException {
        word = br.readLine().toCharArray();

        for (char c : word) {
            int number = c;
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            for (int i = 0; i < sum; i++) {
                sb.append(c);
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
