import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int K;
    String S;

    private void solution() throws IOException {

        K = Integer.parseInt(br.readLine());
        S = br.readLine();

        for (int i = 0; i < S.length(); i += K) {
            sb.append(S.charAt(i));
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
