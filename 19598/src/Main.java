import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static class CLASS {
        int start;
        int end;
        public CLASS(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    static CLASS[] classes;
    static int solution(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(classes[0].end);
        for(int i=1; i<N; i++) {
            if(pq.peek() <= classes[i].start) {
                pq.poll();
                pq.add(classes[i].end);
            } else {
                pq.add(classes[i].end);
            }
        }
        return pq.size();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        classes = new CLASS[N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            classes[i] = new CLASS(start, end);
        }
        Arrays.sort(classes, Comparator.comparingInt(o->o.start));
        System.out.println(solution());
    }
}
