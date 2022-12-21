import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final String[] message = {"Pizza",
            " fits on the table.",
            " does not fit on the table."};
    static double r, w, l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 1; ; i++) {
            st = new StringTokenizer(br.readLine());
            r = Double.parseDouble(st.nextToken());
            if (r == 0) break;
            w = Double.parseDouble(st.nextToken());
            l = Double.parseDouble(st.nextToken());

            sb.append(message[0] + " " + i);
            if (r >= Math.sqrt(Math.pow(w / 2, 2) + Math.pow(l / 2, 2))) sb.append(message[1]).append('\n');
            else sb.append(message[2]).append('\n');
        }

        System.out.print(sb);
    }
}
