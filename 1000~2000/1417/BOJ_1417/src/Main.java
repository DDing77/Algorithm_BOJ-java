import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    static int N;
    static PriorityQueue<Integer> pq;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        pq = new PriorityQueue<>(Collections.reverseOrder());

        N = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());

        res = 0;
        for (int i = 0; i < N - 1; i++) pq.add(Integer.parseInt(br.readLine()));
        if (pq.size() == 0) {
            System.out.println(0);
            return;
        }
        while (num <= pq.peek()) {
            res++;
            pq.add(pq.poll() - 1);
            num++;
        }
        System.out.println(res);
    }
}
