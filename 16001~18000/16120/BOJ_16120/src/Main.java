import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private String input;
    private Stack<Character> stack = new Stack<>();

    private void solution() throws IOException {
        input = br.readLine();

        for (char c : input.toCharArray()) {
            stack.push(c);

            if (stack.size() >= 4) {
                int size = stack.size();
                if (stack.get(size - 1) == 'P'
                        && stack.get(size - 2) == 'A'
                        && stack.get(size - 3) == 'P'
                        && stack.get(size - 4) == 'P') {

                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();

                    stack.push('P');
                }
            }
        }

        if (stack.size() == 1 && stack.peek() == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
