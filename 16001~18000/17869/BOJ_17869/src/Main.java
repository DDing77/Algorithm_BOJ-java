import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private long N;
    private int res;

    private void solution() throws IOException {

        N = Long.parseLong(br.readLine());
        while (N > 1) {
            if ((N & 1) == 0) {
                N /= 2;
            } else {
                N += 1;
            }
            res++;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
