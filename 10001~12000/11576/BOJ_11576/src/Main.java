import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int A, B;
    static int m;
    static int res;
    static int[] arrA;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        arrA = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) arrA[i] = Integer.parseInt(st.nextToken());

        res = 0;
        for (int i = 0; i < m; i++) res = res * A + arrA[i];

        Stack<Integer> stack = new Stack<>();
        while (res > 0) {
            stack.push(res % B);
            res /= B;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb);
    }
}
