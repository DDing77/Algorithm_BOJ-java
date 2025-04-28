import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int a;
    private int b;
    private int c;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        if (a == 0) {
            System.out.println(c * c - b);
        } else if (b == 0) {
            System.out.println(c * c - a);
        } else {
            System.out.println((int) Math.sqrt(a + b));
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
