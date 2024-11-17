import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int N;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            int even = 0;
            int odd = 0;
            while (st.hasMoreTokens()) {
                int val = Integer.parseInt(st.nextToken());
                if ((val & 1) == 0) {
                    even += val;
                } else {
                    odd += val;
                }
            }

            if (even > odd) {
                System.out.println("EVEN");
            } else if (even == odd) {
                System.out.println("TIE");
            } else {
                System.out.println("ODD");
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
