import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Stack<Integer> stack;
    static int res;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        stack = new Stack<>();

        int pre = -1;
        int cur;
        res = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            cur = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                stack.push(cur);
                pre = cur;
            } else {
                if (pre < cur) {
                    pre = cur;
                    continue;
                } else {
                    res = Math.max(res, pre - stack.pop());
                    pre = cur;
                    stack.push(cur);
                }
            }
        }

        if (!stack.isEmpty()) {
            res = Math.max(res, pre - stack.pop());
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
