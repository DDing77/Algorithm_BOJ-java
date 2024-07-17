import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int a;
    private int k;
    private int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (a == 1) {
            System.out.println(1);
        } else if (k == 0) {
            System.out.println(a);
        } else {
            if (a % 2 == 0) {
                System.out.println(1);
            } else {
                System.out.println(a);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
