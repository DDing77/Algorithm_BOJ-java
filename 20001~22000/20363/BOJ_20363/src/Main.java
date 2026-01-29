import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int X;
    private int Y;
    private int res;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        res += X + Y + Math.min(X, Y) / 10;
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
