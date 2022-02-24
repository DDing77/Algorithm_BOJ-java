import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int T, M;
    static void solution() {

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            M = Integer.parseInt(br.readLine());
            int cnt = 0;
            sb.append(M/2 +1).append('\n');
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            for(int i=0; i<M; i++) {
                if(i %10 == 0){
                    st=  new StringTokenizer(br.readLine());
                }
                int now = Integer.parseInt(st.nextToken());


                if( i %2 == 0) maxHeap.add(now);
                else minHeap.add(now);

                if(maxHeap.size() !=0 && minHeap.size() !=0 && maxHeap.peek() > minHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(minHeap.poll());
                }

                if(i %2 ==0) {
                    sb.append(maxHeap.peek()).append(" ");
                    cnt++;
                    if(cnt %10 == 0) sb.append('\n');
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
