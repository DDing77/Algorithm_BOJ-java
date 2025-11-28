import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private char[] A;
    private char[] B;

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());


        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            A = st.nextToken().toCharArray();
            B = st.nextToken().toCharArray();

            int length = A.length;
            int zeroCnt = 0;
            int oneCnt = 0;

            for (int i = 0; i < length; i++) {
                if (A[i] == '0' && B[i] == '1') {
                        oneCnt++;
                } else if (A[i] == '1' && B[i] == '0') {
                        zeroCnt++;
                }
            }

            int moveCnt = Math.min(oneCnt, zeroCnt);
            oneCnt -= moveCnt;
            zeroCnt -= moveCnt;

            int totalRes = moveCnt + Math.max(oneCnt, zeroCnt);
            sb.append(totalRes).append("\n");
        }
        System.out.print(sb);

    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
