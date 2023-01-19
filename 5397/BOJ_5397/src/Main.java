import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static int T;
    static String input;
    static Stack<Character> pre, post;

    public static String getPassword(String input) {
        pre = new Stack<>();
        post = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '<') {
                if (!pre.isEmpty()) {
                    post.push(pre.pop());
                }
            } else if (ch == '>') {
                if (!post.isEmpty()) {
                    pre.push(post.pop());
                }
            } else if (ch == '-') {
                if (!pre.isEmpty()) {
                    pre.pop();
                }
            } else {
                pre.push(ch);
            }
        }

        StringBuilder passWord = new StringBuilder();

        while (!post.isEmpty()) {
            pre.push(post.pop());
        }

        while (!pre.isEmpty()) {
            passWord.append(pre.pop());
        }
        return passWord.reverse().toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input = br.readLine();
            sb.append(getPassword(input)).append('\n');
        }

        System.out.print(sb);
    }
}
