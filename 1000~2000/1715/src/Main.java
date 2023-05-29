import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static PriorityQueue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) pq.add(Long.parseLong(br.readLine()));
        long num = 0;
        while (pq.size()> 1) {
                Long sum = pq.poll();
                sum += pq.poll();
                num += sum;
                pq.add(sum);
        }

        System.out.println(num);
    }
}
