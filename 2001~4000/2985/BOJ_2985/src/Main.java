import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int a;
    static int b;
    static int c;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        if (a + b == c) {
            System.out.println(a + "+" + b + "=" + c);
        } else if (a - b == c) {
            System.out.println(a + "-" + b + "=" + c);
        } else if (a / b == c) {
            System.out.println(a + "/" + b + "=" + c);
        } else if (a * b == c) {
            System.out.println(a + "*" + b + "=" + c);
        } else if (a == b + c) {
            System.out.println(a + "=" + b + "+" + c);
        } else if (a == b - c) {
            System.out.println(a + "=" + b + "-" + c);
        } else if (a == b / c) {
            System.out.println(a + "=" + b + "/" + c);
        } else if (a == b * c) {
            System.out.println(a + "=" + b + "*" + c);
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
