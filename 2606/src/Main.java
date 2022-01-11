import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] computer;
    static boolean[] check;
    static int count = 0;
    static void dfs(int start) {
        check[start] = true;
        for(int i : computer[start]) {
            if(check[i] == true) continue;
            count++;
            dfs(i);
        }
    }
    static void getAns() {
        dfs(1);
        System.out.println(count);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        computer = new ArrayList[N+1];
        check = new boolean[N+1];

        for(int i=1; i<=N; i++) {
            computer[i] = new ArrayList<>();
        }

        for( int i=1; i<=M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            computer[x].add(y);
            computer[y].add(x);
        }
        for(int i=1; i<=N; i++) {
            Collections.sort(computer[i]);
        }
        getAns();
    }
}
