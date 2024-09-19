import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int C;
    private int K;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        double unit = Math.pow(10, K);

        System.out.println((int)(((int)Math.round(C / unit)) * unit));
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
