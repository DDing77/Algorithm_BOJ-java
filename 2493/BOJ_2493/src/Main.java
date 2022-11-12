import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int[] res;
    static Stack<Info> stackLeft, stackRight;

    static class Info {
        private int value;
        private int idx;

        public Info(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        res = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        stackLeft = new Stack<>();
        for (int i = 0; i < N; i++) {
            stackLeft.push(new Info(Integer.parseInt(st.nextToken()), i + 1));
        }

        stackRight = new Stack<>();
        int idx = N;
        int arrIdx = N;
//        5
//        4 2 3 5 1
//        0 1 1 0 4
        while (!stackLeft.isEmpty()) {

            if (stackRight.isEmpty()) {
                stackRight.push(stackLeft.pop());
                idx--;
            }

            while (!stackLeft.isEmpty() && !stackRight.isEmpty() && stackLeft.peek().value >= stackRight.peek().value) {
                res[stackRight.pop().idx] = idx;

            }

            while (!stackLeft.isEmpty() && !stackRight.isEmpty() && stackLeft.peek().value < stackRight.peek().value) {
                stackRight.push(stackLeft.pop());
                idx--;
            }
        }

        for (int i = 1; i <= N; i++) sb.append(res[i] + " ");
        System.out.println(sb);
    }
}
