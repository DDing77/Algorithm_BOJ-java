import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int L;
    private int max;
    private int sameCnt;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        max = 0;
        sameCnt = 0;
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();

            int count = 0;
            char pre = input[0];
            for (int j = 1; j < L; j++) {
                if (pre != input[j]) {
                    if (pre == '1') {
                        count++;
                    }
                }
                pre = input[j];
            }
            if (pre == '1') {
                count++;
            }

            if (max < count) {
                max = count;
                sameCnt = 1;
            } else if (max == count) {
                sameCnt++;
            }
        }

        sb.append(max).append(" ").append(sameCnt);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
