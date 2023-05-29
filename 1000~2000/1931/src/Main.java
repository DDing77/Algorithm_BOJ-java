import java.io.*;
import java.util.*;

public class Main {
    public static class MEET implements Comparable<MEET> {
        int start, end;
        public MEET(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(MEET o) {
            if(end  == o.end) {
                return start - o.start;
            }
            return end - o.end;
        }
    }
    static MEET[] meet;
    static int cnt=1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        meet = new MEET[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            meet[i] = new MEET(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(meet);
//        for(int i=0; i<N;i++) {
//            System.out.println(meet[i].start);
//        }
        int curTime=meet[0].end;
        for(int i=1; i<N; i++) {
            if(meet[i].start >= curTime){
                curTime = meet[i].end;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
