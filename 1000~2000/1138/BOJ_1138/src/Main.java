import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        res = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int move = Integer.parseInt(st.nextToken());
            int value = i + 1;
            int idx = 0;
            while (move > 0) {
                if (res[idx] == 0) {
                    move--;
                }
                idx++;
            }
            while (res[idx] != 0) idx++;
            res[idx] = value;
        }

        for (int num : res) sb.append(num).append(" ");
        System.out.println(sb);
    }
}
