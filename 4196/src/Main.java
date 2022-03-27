import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int T, N, M;
    static int id;
    static int SCCCNT;
    static int[] node;
    static boolean[] finished;
    static Stack<Integer> stack;
    static ArrayList<ArrayList<Integer>> SCC;
    static ArrayList<Integer>[] edge;
    static int[] group;
    static boolean[] inDegree;

    static int DFS(int x) {
        node[x] = ++id;
        stack.push(x);

        int result = node[x];
        for (int y : edge[x]) {
            if (node[y] == 0) result = Math.min(result, DFS(y));
            else if (!finished[y]) result = Math.min(result, node[y]);
        }

        if (result == node[x]) {
            ArrayList<Integer> scc = new ArrayList<>();
            SCCCNT++;
            while (true) {
                int top = stack.pop();
                scc.add(top);
                group[top] = SCC.size() + 1;
                finished[top] = true;
                if (top == x) break;
            }
            SCC.add(scc);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            node = new int[N + 1];
            finished = new boolean[N + 1];
            stack = new Stack<>();
            SCC = new ArrayList<>();
            edge = new ArrayList[N + 1];
            group = new int[N+1];
            for (int i = 0; i <= N; i++) edge[i] = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                edge[start].add(end);
            }

            SCCCNT = 0;
            for (int i = 1; i <= N; i++) {
                if (node[i] == 0) DFS(i);
            }

            inDegree = new boolean[SCC.size()+1];

            for(int i=1; i<=N; i++) {
                for(int y : edge[i]) {
                    if(group[i] != group[y]){
                        inDegree[group[y]] = true;
                    }
                }
            }
            int result = 0;
            for(int i=1; i<=SCC.size(); i++) {
                if(!inDegree[i]) result++;
            }
            sb.append(result).append('\n');
        }
        System.out.print(sb);
    }
}
