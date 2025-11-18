import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int S;
    private int B;
    private int[] pre;
    private int[] next;

    private void solution() throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            if (S == 0 && B == 0) {
                break;
            }

            pre = new int[S + 2];
            next = new int[S + 2];

            for (int i = 1; i < S; i++) {
                next[i] = i + 1;
                pre[i + 1] = i;
            }

            for (int i = 0; i < B; i++) {
                st = new StringTokenizer(br.readLine());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());

                int a = pre[left];
                int b= next[right];

                if (a == 0) {
                    sb.append("*");
                } else {
                    sb.append(a);
                }
                sb.append(" ");
                if (b == 0) {
                    sb.append("*");
                } else {
                    sb.append(b);
                }
                sb.append("\n");

                pre[b] = a;
                next[a] = b;
            }
            sb.append("-").append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
