import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private long[] wordBitArr;
    private long status = (1 << 26) - 1;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        wordBitArr = new long[N];
        for (int i = 0; i < N; i++) {
            char[] word = br.readLine().toCharArray();
            long wordBit = 0;
            for (char c : word) {
                wordBit |= 1 << (c - 'a');
            }
            wordBitArr[i] = wordBit;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            if (op == 1) {
                status -= 1L << (c - 'a');
            } else if (op == 2) {
                status += 1L << (c - 'a');
            }

            int cnt = 0;
            for (long wordBit : wordBitArr) {
                if (wordBit == (wordBit & status)) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
