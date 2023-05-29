import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] visit;
    static int[] parent;
    static ArrayList<Integer>[] list;
    static StringBuilder sb = new StringBuilder();
    static void solution(){
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        visit[1] = true;
        while(!que.isEmpty()) {
            int x = que.poll();
            for(int child : list[x]) {
                if(!visit[child]) {
                    parent[child] = x;
                    que.add(child);
                    visit[child] = true;
                }
            }
        }
        for(int i = 2; i<=N; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        parent = new int[N+1];
        list = new ArrayList[N+1];

        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        solution();
    }
}
