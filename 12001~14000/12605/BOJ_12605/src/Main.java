import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static final String message = "Case #";
    static int N;
    static Stack<String> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            stack = new Stack<>();
            while (st.hasMoreTokens()) {
                stack.push(st.nextToken());
            }

            sb.append(message).append(i).append(": ");
            while (!stack.isEmpty()) {
                sb.append(stack.pop() + " ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
