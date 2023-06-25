import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int a;
    static int b;
    static int c;
    static double e;
    static double f;
    static double res;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        e = Math.sqrt(a * a - b * b);
        f = Math.sqrt(a * a - c * c);

        res = (e * f - b * c) / a;

        if (res <= 0) {
            System.out.println(-1);
        } else {
            System.out.println(String.format("%.0f", res));
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
