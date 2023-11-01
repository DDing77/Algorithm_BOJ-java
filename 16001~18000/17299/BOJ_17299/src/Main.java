import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    final int LENGTH = 1_000_001;
    int N;
    int[] number;
    int[] count;
    int[] res;
    Stack<Integer> stack;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        number = new int[N];
        count = new int[LENGTH];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
            count[number[i]]++;
        }

        res = new int[N];
        stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }
            while (!stack.isEmpty() && count[number[i]] > count[number[stack.peek()]]) {
                res[stack.pop()] = number[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }

        for (int i = 0; i < N; i++) {
            sb.append(res[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
