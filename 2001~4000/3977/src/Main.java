import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int T, N, M;
    static int id;

    static int[] group;
    static int[] inDegree;
    static int[] node;
    static boolean[] finished;
    static ArrayList<Integer>[] edge;
    static ArrayList<ArrayList<Integer>> SCC;
    static Stack<Integer> stack;

    static int DFS(int x) {
        node[x] = id++;
        stack.push(x);
        int result = node[x];


        for (int next : edge[x]) {
            if (node[next] == 0) result = Math.min(result, DFS(next));
            else if (!finished[next]) result = Math.min(result, node[next]);
        }

        if (result == node[x]) {
            ArrayList<Integer> scc = new ArrayList<>();
            while (true) {
                int top = stack.pop();
                scc.add(top);
                finished[top] = true;
                group[top] = SCC.size();
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

        for (int t = 0; t < T; t++) {
            if (t != 0) br.readLine();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int id = 0;
            node = new int[N];
            group = new int[N];
            finished = new boolean[N];
            stack = new Stack<>();
            SCC = new ArrayList<>();
            edge = new ArrayList[N];
            for (int i = 0; i < N; i++) edge[i] = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                edge[start].add(end);
            }

            for (int i = 0; i < N; i++) {
                if (node[i] == 0) DFS(i);
            }

            inDegree = new int[SCC.size() + 1];

            for (int i = 0; i < N; i++) {
                for (int y : edge[i]) {
                    if (group[i] != group[y]) {
                        inDegree[group[y]]++;
                    }
                }
            }

            int startPointCnt = 0;
            int startPoint = 0;

            for (int i = 0; i < SCC.size(); i++) {
                if (inDegree[i] == 0) {
                    startPoint = i;
                    startPointCnt++;
                }
            }

            if (startPointCnt > 1) sb.append("Confused").append('\n');
            else {
                for (int i = 0; i < N; i++) {
                    if (group[i] == startPoint) sb.append(i).append('\n');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
