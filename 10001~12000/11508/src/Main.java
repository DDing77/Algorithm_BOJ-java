import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static int res;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) pq.add(Integer.parseInt(br.readLine()));

        while(!pq.isEmpty()) {
            if(pq.size() < 3) res+= pq.poll();
            else {
                for(int i=0; i<2; i++) res += pq.poll();
                pq.poll();
            }
        }
        System.out.println(res);
    }
}