import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int T;
    int N;
    double D;
    int v;
    int f;
    int c;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Long.parseLong(st.nextToken());

            res = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                v = Integer.parseInt(st.nextToken());
                f = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());

                if ((D / v) * c <= f) {
                    res++;
                }
            }

            sb.append(res).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
