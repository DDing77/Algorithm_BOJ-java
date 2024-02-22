import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    String[] expression;
    List<Integer> res;

    private int calculate(int value, String op, int curNumber) {

        if (op.equals("+")) {
            value += curNumber;
        } else if (op.equals("-")) {
            value -= curNumber;
        } else if (op.equals("*")) {
            value *= curNumber;
        } else {
            value /= curNumber;
        }
        return value;
    }

    private int forward(String[] expression) {

        int value = Integer.parseInt(expression[0]);
        String op = expression[1];
        value = calculate(value, op, Integer.parseInt(expression[2]));

        for (int i = 3; i < expression.length; i++) {
            if (i % 2 == 1) {
                op = expression[i];
                continue;
            }

            int curNumber = Integer.parseInt(expression[i]);
            value = calculate(value, op, curNumber);
        }

        return value;
    }

    private int backward(String[] expression) {

        int value = Integer.parseInt(expression[expression.length - 3]);
        String op = expression[expression.length - 2];
        value = calculate(value, op, Integer.parseInt(expression[expression.length - 1]));

        for (int i = expression.length - 4; i >= 0; i--) {
            if (i % 2 == 1) {
                op = expression[i];
                continue;
            }

            int curNumber = Integer.parseInt(expression[i]);
            value = calculate(curNumber, op, value);
        }

        return value;
    }

    private void solution() throws IOException {

        expression = br.readLine().split(" ");

        res = new ArrayList<>();

        res.add(forward(expression));
        res.add(backward(expression));

        Collections.sort(res);

        for (int value : res) {
            sb.append(value).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
