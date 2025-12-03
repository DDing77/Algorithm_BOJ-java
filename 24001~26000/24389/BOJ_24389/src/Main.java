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
        int temp = N;
        for (int i = 0; i < 32; i++) {
            temp ^= 1 <<i;
        }
        temp++;

        for (int i = 0; i < 32; i++) {
            int idx = 1 << i;
            if ((N & idx) != (temp & idx)) {
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
