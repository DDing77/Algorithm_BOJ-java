import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static int N;
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        int res = 0;
        while (N-- > 0) {
            stack = new Stack<>();
            char[] ch = br.readLine().toCharArray();

            for (int i = 0; i < ch.length; i++) {
                if (stack.isEmpty()) stack.push(ch[i]);
                else {
                    if (stack.peek() != ch[i]) stack.push(ch[i]);
                    else stack.pop();
                }
            }

            if (stack.isEmpty()) res++;
        }

        System.out.println(res);
    }
}
