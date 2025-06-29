import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private void solution() throws IOException {
        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int res = 0;
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            res += (X - x);
        }

        System.out.println(res + X);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
