import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static long[] arr;
    static int K, N;
    static void solution(){
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0; i<K; i++) {
            pq.add(arr[i]);
        }
        long head;
        for(int i=0; i<N-1; i++) {
            head = pq.poll();
            for(int j=0; j<K; j++) {
                pq.add(head*arr[j]);
                if(head % arr[j] == 0) break;
            }
        }
        System.out.println(pq.poll());
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr= new long[K];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }
}
