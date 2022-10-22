import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static String input;
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        stack = new Stack<>();
        input = br.readLine();

        int res = 0;

        int cnt = 0;
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (cur == '(') cnt++;
            else {
                cnt--;
                if (input.charAt(i - 1) == '(') res += cnt;
                else res++;
            }
        }
        System.out.println(res);
    }
}