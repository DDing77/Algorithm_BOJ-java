import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int X;
    private int Y;

    private void solution() throws IOException {

        X = Integer.parseInt(br.readLine());
        Y = Integer.parseInt(br.readLine());

        for (int i = X; i <= Y; i += 60) {
            sb.append("All positions change in year ").append(i).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
