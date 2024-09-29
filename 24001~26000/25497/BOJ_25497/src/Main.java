import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private String input;
    private int res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        input = br.readLine();

        Stack<Character> preLRSkill = new Stack<>();
        Stack<Character> preSKSkill = new Stack<>();
        for (int i = 0; i < N; i++) {
            char cur = input.charAt(i);
            if ('1' <= cur && cur <= '9') {
                res++;
            } else if (cur == 'L') {
                preLRSkill.add(cur);
            } else if (cur == 'R') {
                if (preLRSkill.isEmpty() || preLRSkill.peek() != 'L') {
                    break;
                } else {
                    res++;
                    preLRSkill.pop();
                }
            } else if (cur == 'S') {
                preSKSkill.add(cur);
            } else if (cur == 'K') {
                if (preSKSkill.isEmpty() || preSKSkill.peek() != 'S') {
                    break;
                } else {
                    res++;
                    preSKSkill.pop();
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
