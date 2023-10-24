import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    int N;
    Deque<Integer> dq;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dq = new ArrayDeque<>();

        int op;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            op = Integer.parseInt(st.nextToken());

            if (op == 1) {
                dq.addFirst(Integer.parseInt(st.nextToken()));
            } else if (op == 2) {
                dq.addLast(Integer.parseInt(st.nextToken()));
            } else if (op == 3) {
                if (dq.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(dq.removeFirst()).append('\n');
                }
            } else if (op == 4) {
                if (dq.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(dq.removeLast()).append('\n');
                }
            } else if (op == 5) {
                sb.append(dq.size()).append('\n');
            } else if (op == 6) {
                if (dq.isEmpty()) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else if (op == 7) {
                if (dq.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(dq.peekFirst()).append('\n');
                }
            } else if (op == 8) {
                if (dq.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(dq.getLast()).append('\n');
                }
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}

