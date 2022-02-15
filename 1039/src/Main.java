import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Num{
        int num;
        int cnt;
        public Num(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    static int N, K , result = -1;
    static boolean[][] isVisit;

    static int swap(int number, int i, int j) {
        char[] num = String.valueOf(number).toCharArray();
        if( i ==0 && num[j] == '0') return -1;

        char tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
        return Integer.parseInt(String.valueOf(num));
    }
    static void bfs(){
        Queue<Num> que = new LinkedList<>();
        que.add(new Num(N, 0));
        isVisit[N][0] = true;

        while(!que.isEmpty()) {
            Num cur = que.poll();
            if( cur.cnt == K) {
                result = Math.max(result, cur.num);
                continue;
            }
            int NLen = String.valueOf(cur.num).length();
            for(int i=0; i<NLen-1; i++) {
                for(int j=i+1; j<NLen; j++) {
                    int next = swap(cur.num, i, j);
                    if( next != -1 && !isVisit[next][cur.cnt+1]){
                        que.add(new Num(next, cur.cnt+1));
                        isVisit[next][cur.cnt+1] = true;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        isVisit = new boolean[1000001][K+1];
        bfs();
        System.out.println(result);
    }
}
