import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr;
    static int[] res;
    static boolean[] visit;
    static void backTrack(int start, int cnt) {
        if(cnt == M) {
            for(int i=0; i<M; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append('\n');
            return;
        }
        int num = 0;
        for(int i = start; i<N; i++) {
            if(!visit[i]) {
                if( num == arr[i]) continue;
                visit[i] = true;
                res[cnt] = arr[i];
                backTrack(i+1,cnt+1);
                visit[i] = false;
                num = arr[i];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visit = new boolean[N];
        res = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        backTrack(0,0);
        System.out.println(sb);
    }
}
