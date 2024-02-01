import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int N;

    private String getHorizon(int size) {

        StringBuilder horizon = new StringBuilder();

        for (int i = 0; i < size + 2; i++) {
            horizon.append("@");
        }

        return horizon.append("\n").toString();
    }

    private String getVertical(int size) {

        StringBuilder vertical = new StringBuilder();

        for (int i = 0; i < size + 2; i++) {
            if (i == 0 || i == size + 1) {
                vertical.append("@");
                continue;
            }

            vertical.append(" ");
        }

        return vertical.append("\n").toString();
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        sb.append(getHorizon(N));
        for (int i = 0; i < N; i++) {
            sb.append(getVertical(N));
        }
        sb.append(getHorizon(N));

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
