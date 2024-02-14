import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int a;
    int b;
    int x;
    int y;
    int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        if (b < a) {
            int temp = a;
            a = b;
            b = temp;
        }

        if (y < x) {
            int temp = x;
            x = y;
            y = temp;
        }

        res = Math.min(Math.abs(a - x) + Math.abs(b - y), b - a);
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
