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
    static void dfs(int depth){
        if(depth == M) {
            for(int i=0; i<M; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                res[depth] = arr[i];
                dfs(depth+1);
                visit[i] = false;
            }
        }
    }
    static void solution(){
        Arrays.sort(arr);
        dfs(0);
        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr= new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visit = new boolean[N];
        res = new int[M];
        solution();
    }
}
