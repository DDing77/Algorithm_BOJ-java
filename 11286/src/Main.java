import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// author : DDing
// solution : PriorityQueue

public class Main {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>( (o1, o2) ->
        Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1, o2) : Integer.compare(Math.abs(o1), Math.abs(o2))
    );
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input != 0) {
                pq.add(input);
            }else {
                if(pq.isEmpty()) sb.append(0).append('\n');
                else sb.append(pq.poll()).append('\n');
            }
        }
        System.out.print(sb);
    }
}
