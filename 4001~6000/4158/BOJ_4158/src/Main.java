import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static Set<Integer> set;
    static int N, M;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                set.add(Integer.parseInt(br.readLine()));
            }

            res = 0;
            for (int i = 0; i < M; i++) {
                if (set.contains(Integer.parseInt(br.readLine()))) {
                    res++;
                }
            }

            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }
}
