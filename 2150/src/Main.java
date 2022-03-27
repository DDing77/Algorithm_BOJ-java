import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static int id;
    static int[] node;
    static boolean[] finished;
    static Stack<Integer> stack;
    static ArrayList<ArrayList<Integer>> SCC;
    static ArrayList<Integer>[] edge;

    static int DFS(int x) {
        node[x] = ++id;
        stack.push(x);

        int result = node[x];
        for(int y : edge[x]) {
            if(node[y] == 0) result = Math.min(result, DFS(y));
            else if(!finished[y]) result = Math.min(result, node[y]);
        }

        if(result == node[x]) {
            ArrayList<Integer> scc = new ArrayList<>();
            while(true) {
                int top = stack.pop();
                scc.add(top);
                finished[top]  = true;
                if(top == x) break;
            }
            Collections.sort(scc);
            SCC.add(scc);
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        node = new int[V+1];
        finished = new boolean[V+1];
        stack = new Stack<>();
        SCC= new ArrayList<>();
        edge = new ArrayList[V+1];
        for(int i=0; i<=V; i++) edge[i] = new ArrayList<>();

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            edge[start].add(end);
        }

        for(int i=1; i<=V; i++) {
            if(node[i] ==0) DFS(i);
        }
        sb.append(SCC.size()).append('\n');
        for (int i = 0; i < SCC.size(); i++) {
            Collections.sort(SCC, (o1, o2) -> o1.get(0) - o2.get(0));

        }

        for(int i=0; i<SCC.size();i++) {
            for(int j=0; j<SCC.get(i).size(); j++) sb.append(SCC.get(i).get(j)).append(" ");
            sb.append("-1").append('\n');
        }

        System.out.print(sb);
    }
}
