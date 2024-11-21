import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int K;
    private String str;

    private void solution() throws IOException {

        K = Integer.parseInt(br.readLine());
        str = br.readLine();

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < str.length() / K; j++) {
                sb.append(str.charAt(j % 2 == 0 ? j * K + i : j * K + K - i- 1));
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
