import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final String[] message = {
            "advertise",
            "do not advertise",
            "does not matter"
    };
    static int N;
    static int r, e, c;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            res = e - c;
            if (res > r) {
                sb.append(message[0]);
            } else if (res == r) {
                sb.append(message[2]);
            } else {
                sb.append(message[1]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
