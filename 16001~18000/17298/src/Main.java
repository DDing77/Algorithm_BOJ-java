import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;

    static class Info {
        int value;
        int order;

        public Info(int value, int order) {
            this.value = value;
            this.order = order;
        }
    }

    static Stack<Info> stack;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        stack = new Stack<>();
        res = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (i == 0) {
                stack.push(new Info(now, i));
                continue;
            }
            while (!stack.isEmpty() && stack.peek().value < now) {
                Info pre = stack.pop();
                res[pre.order] = now;
            }

            stack.push(new Info(now, i));
        }

        while (!stack.isEmpty()) {
            Info pre = stack.pop();
            res[pre.order] = -1;
        }

        for (int NGE : res) sb.append(NGE).append(" ");
        System.out.println(sb);
    }
}
