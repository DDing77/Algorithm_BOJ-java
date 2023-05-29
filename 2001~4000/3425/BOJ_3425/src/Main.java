import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N, T;
    static long firstNumber;
    static boolean error;
    static ArrayList<String> operations;
    static ArrayList<Long> NUMList;
    static Stack<Long> stack;

    static boolean NUM(long num) {
        stack.push(num);
        return false;
    }

    static boolean POP() {
        if (stack.isEmpty()) return true;
        stack.pop();
        return false;
    }

    static boolean INV() {
        if (stack.isEmpty()) return true;
        long temp = stack.pop();
        stack.push(-temp);
        return false;
    }

    static boolean DUP() {
        if (stack.isEmpty()) return true;
        stack.push(stack.peek());
        return false;
    }

    static boolean SWP() {
        if (stack.size() < 2) return true;
        long first = stack.pop();
        long second = stack.pop();
        stack.push(first);
        stack.push(second);
        return false;
    }

    static boolean ADD() {
        if (stack.size() < 2) return true;
        long first = stack.pop();
        long second = stack.pop();
        stack.push(first + second);
        return false;
    }

    static boolean SUB() {
        if (stack.size() < 2) return true;
        long first = stack.pop();
        long second = stack.pop();
        stack.push(second - first);
        return false;
    }

    static boolean MUL() {
        if (stack.size() < 2) return true;
        long first = stack.pop();
        long second = stack.pop();
        stack.push(second * first);
        return false;
    }

    static boolean DIV() {
        if (stack.size() < 2) return true;
        int minus = 0;
        long first = stack.pop();
        if (first < 0) minus++;
        if (first == 0) return true;
        long second = stack.pop();
        if (second < 0) minus++;

        long newNum = second / first;
        if (minus == 1) newNum = -Math.abs(newNum);
        else newNum = Math.abs(newNum);

        stack.push(newNum);
        return false;
    }

    static boolean MOD() {
        if (stack.size() < 2) return true;
        int minus = 0;
        long first = stack.pop();
        if (first == 0) return true;
        long second = stack.pop();
        if (second < 0) minus++;

        long newNum = second % first;
        if (minus == 1) newNum = -Math.abs(newNum);
        else newNum = Math.abs(newNum);

        stack.push(newNum);
        return false;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {

            operations = new ArrayList<>();
            NUMList = new ArrayList<>();
            while (true) {
                String[] input = br.readLine().split(" ");
                String op = input[0];

                if (op.equals("QUIT")) {
                    System.out.println(sb);
                    return;
                } else if (op.equals("END")) break;
                else if (op.equals("NUM")) {
                    long num = Long.parseLong(input[1]);
                    NUMList.add(num);
                }
                operations.add(op);
            }

            T = Integer.parseInt(br.readLine());
            while (T-- > 0) {
                int NUMListIdx = 0;
                firstNumber = Integer.parseInt(br.readLine());
                stack = new Stack<>();
                stack.push(firstNumber);

                error = false;

                for (int i = 0; i < operations.size(); i++) {
                    if (operations.get(i).equals("NUM")) error = NUM(NUMList.get(NUMListIdx++));
                    else if (operations.get(i).equals("POP")) error = POP();
                    else if (operations.get(i).equals("INV")) error = INV();
                    else if (operations.get(i).equals("DUP")) error = DUP();
                    else if (operations.get(i).equals("SWP")) error = SWP();
                    else if (operations.get(i).equals("ADD")) error = ADD();
                    else if (operations.get(i).equals("SUB")) error = SUB();
                    else if (operations.get(i).equals("MUL")) error = MUL();
                    else if (operations.get(i).equals("DIV")) error = DIV();
                    else if (operations.get(i).equals("MOD")) error = MOD();
//                    System.out.println("operation : " + operations.get(i));
//                    System.out.println("stack top: " + stack.peek() + " stack size :" + stack.size());
                    if (!stack.isEmpty() && (stack.peek() > 1e9 || stack.peek() < -1e9)) error = true;
                    if (error) break;
                }

                if (error || stack.size() != 1) sb.append("ERROR").append('\n');
                else sb.append(stack.peek()).append('\n');
            }
            sb.append('\n');
        }
    }
}
