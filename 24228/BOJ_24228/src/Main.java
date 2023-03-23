import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private long N, R;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        R = Long.parseLong(st.nextToken());

        System.out.println(N + 1 + 2 * (R - 1));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
