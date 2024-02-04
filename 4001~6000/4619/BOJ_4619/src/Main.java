import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int B;
    int N;
    int res;

    private void solution() throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            B = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            if (B == 0 && N == 0) {
                break;
            }

            int A = 0;
            while (true) {
                if (B < Math.pow(A, N)) {
                    break;
                }
                A++;
            }

            if (Math.abs(B - Math.pow(A - 1, N)) < Math.abs(Math.pow(A, N) - B)) {
                res = A - 1;
            } else {
                res = A;
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
