import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static Deque<Integer> dq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dq = new ArrayDeque<>();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) dq.add(Integer.parseInt(br.readLine()));

        int last = dq.pollLast();

        int res = 1;
        while (!dq.isEmpty()) {
            int cur = dq.pollLast();
            if (cur > last) {
                res++;
                last = cur;
            }
        }

        System.out.println(res);
    }
}
