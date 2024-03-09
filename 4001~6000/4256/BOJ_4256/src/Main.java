import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int T;
    int N;
    int[] pre;
    int[] in;

    private void postSearch(int preRootNum, int left, int right) {
        int inRootNum = pre[preRootNum];

        for (int i = left; i <= right; i++) {
            if (in[i] == inRootNum) {
                postSearch(preRootNum + 1, left, i);
                postSearch(preRootNum + (i - left + 1), i + 1, right);
                sb.append(inRootNum).append(" ");
                return;
            }
        }
    }

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            pre = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                pre[i] = Integer.parseInt(st.nextToken());
            }

            in = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                in[i] = Integer.parseInt(st.nextToken());
            }

            postSearch(0, 0, N - 1);
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
