import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int tc, N;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            N = Integer.parseInt(br.readLine());
            res = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) res += Integer.parseInt(st.nextToken());
            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }
}
