import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String num = String.valueOf(i);
            res++;
            if (i == N) {
                break;
            }
            if (num.contains("50")) {
                res++;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
