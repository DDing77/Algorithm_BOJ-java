import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final String message = "Case ";
    static int L, P, V;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            if (L == 0 && P == 0 && V == 0) break;

            res = 0;

            res += L * (V / P) + Math.min(V % P, L);

            sb.append(message).append(testCase++).append(": ").append(res).append('\n');
        }
        System.out.print(sb);
    }
}
