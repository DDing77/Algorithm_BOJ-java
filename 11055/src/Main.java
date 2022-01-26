import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            dq.add(i);
        }

        while(dq.size()>=2) {
            dq.pollFirst();
            int first = dq.poll();
            dq.addLast(first);
        }
        System.out.println(dq.peek());
    }
}
