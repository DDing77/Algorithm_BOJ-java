import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long diff = Long.MAX_VALUE;
    static int idx = -1;
    static class Info {
        int idx;
        int value;
        public Info(int idx, int value) {
            this.idx = idx;
            this.value= value;
        }
    }
    static ArrayList<Info> list = new ArrayList<>();
    static long[] sumLeft;
    static long[] sumRight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list.add(new Info(idx, value));
        }
        Collections.sort(list, Comparator.comparingInt(o->o.idx));
        sumLeft = new long[N];
        sumRight = new long[N];
        sumLeft[0] = list.get(0).value;
        sumRight[N-1] = list.get(N-1).value;

        for(int i=1; i<N; i++) {
            sumLeft[i] = sumLeft[i-1] + list.get(i).value;
            sumRight[N-1-i] = sumRight[N-i] + list.get(N-1-i).value;
        }
        for(int i=0; i<N; i++) {
            long d= Math.abs(sumLeft[i] - sumRight[i]);
            if(diff > d) {
                idx = i;
                diff = d;
            }
        }
        System.out.println(list.get(idx).idx);
    }
}
// 2 1  x  5
// 1 2  x  4