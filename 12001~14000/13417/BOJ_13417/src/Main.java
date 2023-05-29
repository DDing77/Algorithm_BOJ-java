import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int T, N;
    static Deque<Character> dq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            dq = new ArrayDeque<>();
            dq.add(st.nextToken().charAt(0));

            while (st.hasMoreTokens()) {
                char cur = st.nextToken().charAt(0);
                if (cur <= dq.peekFirst()) dq.addFirst(cur);
                else dq.addLast(cur);
            }

            while (!dq.isEmpty()) {
                sb.append(dq.pollFirst());
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
