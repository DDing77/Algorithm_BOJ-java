import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parent;
    static int find(int target) {
        if(target == parent[target]) return target;
        return parent[target] = find(parent[target]);
    }
    static boolean union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if(x == y) return false;
        parent[y] =x;
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=0; i<=N; i++) {
            parent[i] = i;
        }
        for(int i=1; i<=M; i++) {
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if( !union(a,b)){
                System.out.println(i);
                System.exit(0);
            }
        }
        System.out.println(0);
    }
}
