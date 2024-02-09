import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int K;
    int h;
    String op;

    private void solution() throws IOException {

        K = Integer.parseInt(br.readLine());
        for (int i = 1; i <= K; i++) {
            h = Integer.parseInt(br.readLine());
            op = br.readLine();

            for (int j = 0; j < op.length(); j++) {
                if (op.charAt(j) == 'c') {
                    h++;
                } else {
                    h--;
                }
            }

            sb.append("Data Set ").append(i).append(":").append("\n").append(h).append("\n").append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
