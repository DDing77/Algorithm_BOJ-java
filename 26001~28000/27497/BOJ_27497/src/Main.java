import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private ArrayDeque<Node> dq = new ArrayDeque<>();

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        int idx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());

            if (op == 1) {
                char ch = st.nextToken().charAt(0);
                dq.addLast(new Node(idx++, ch));
            } else if (op == 2) {
                char ch = st.nextToken().charAt(0);
                dq.addFirst(new Node(idx++, ch));
            } else if (op == 3) {
                if (dq.isEmpty()) {
                    continue;
                } else if (dq.size() == 1) {
                    dq.removeFirst();
                } else {
                    if (dq.peekFirst().idx > dq.peekLast().idx) {
                        dq.removeFirst();
                    } else {
                        dq.removeLast();
                    }
                }
            }
        }

        if (dq.isEmpty()) {
            System.out.println("0");
            return;
        }

        for (Node node : dq) {
            sb.append(node.ch);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Node {
        int idx;
        char ch;

        public Node(int idx, char ch) {
            this.idx = idx;
            this.ch = ch;
        }
    }
}
