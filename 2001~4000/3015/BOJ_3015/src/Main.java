import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    Stack<int[]> stack;
    long res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        stack = new Stack<>();
        res = 0L;
        for (int i = 0; i < N; i++) {
            int curHeight = Integer.parseInt(br.readLine());

            while (!stack.isEmpty() && stack.peek()[0] < curHeight) {
                res += stack.pop()[1];
            }

            if (stack.isEmpty()) {
                stack.add(new int[]{curHeight, 1});
                continue;
            }

            if (stack.peek()[0] == curHeight) {
                if (stack.size() >= 2) {
                    res++;
                }
                res += stack.peek()[1];
                stack.peek()[1]++;
            } else if (stack.peek()[0] > curHeight) {
                res++;
                stack.add(new int[]{curHeight, 1});
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
