import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int T, S;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        if (S == 1 || (0 <= T && T < 12) || (16 < T && T <= 23)) {
            System.out.println(280);
        } else {
            System.out.println(320);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
