import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr= new int[N];
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for(int i=0; i<N; i++) {
            int cur = Integer.parseInt(br.readLine());
            if(cur != 0) que.add(cur);
            else if( que.isEmpty()) sb.append(0).append('\n');
            else {
                sb.append(que.poll()).append('\n');
            }
        }
        System.out.println(sb);
    }
}
