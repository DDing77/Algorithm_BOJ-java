import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N;

    static class Balloon {
        int idx;
        int next;

        public Balloon(int idx, int next) {
            this.idx = idx;
            this.next = next;
        }
    }

    static Deque<Balloon> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());
            dq.add(new Balloon(i, value));
        }

        while (!dq.isEmpty()) {
            sb.append(dq.getFirst().idx).append(" ");
            int next = dq.pollFirst().next;
            if (dq.isEmpty()) break;

            if (next <= 0) {
                for (int i = 0; i <Math.abs(next); i++) {
                    dq.addFirst(dq.pollLast());
                }
            } else {
                for (int i = 0; i < next - 1; i++) {
                    dq.addLast(dq.pollFirst());
                }
            }
        }
        System.out.println(sb);
    }
}
