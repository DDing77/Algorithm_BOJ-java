import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    int T;
    int votes;

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            votes = Integer.parseInt(br.readLine());

            while (votes >= 5) {
                sb.append("++++ ");
                votes -= 5;
            }

            sb.append("|".repeat(Math.max(0, votes)));

            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
