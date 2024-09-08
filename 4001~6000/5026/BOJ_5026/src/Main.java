import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private String input;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            input = br.readLine();
            if (input.equals("P=NP")) {
                sb.append("skipped");
            } else {
                String[] number = input.split("\\+");
                sb.append(Integer.parseInt(number[0]) + Integer.parseInt(number[1]));
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
