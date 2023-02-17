import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int T, J, N, row, col;
    static int res, idx;
    static Integer[] boxs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            J = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            boxs = new Integer[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                row = Integer.parseInt(st.nextToken());
                col = Integer.parseInt(st.nextToken());

                boxs[i] = row * col;
            }

            Arrays.sort(boxs, Comparator.reverseOrder());

            res = 0;
            idx = 0;
            while (J > 0) {
                res += 1;
                J -= boxs[idx++];
            }
            sb.append(res).append('\n');
        }
        System.out.print(sb);
    }
}
