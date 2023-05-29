import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final String[] message = {"You get ", " piece(s) and your dad gets ", " piece(s)."};
    static int T;
    static int c;
    static int v;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            sb.append(message[0]).append(c / v).append(message[1]).append(c % v).append(message[2]).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
