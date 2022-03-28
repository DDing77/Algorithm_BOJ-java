import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int id;

    static int[] group;
    static int[] outDegree;
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

        while (true) {
            st = new StringTokenizer(br.readLine());
            if ((N = Integer.parseInt(st.nextToken())) == 0) break;
            M = Integer.parseInt(st.nextToken());

            int id = 0;
            node = new int[N + 1];
            group = new int[N + 1];
            finished = new boolean[N + 1];
            stack = new Stack<>();
            SCC = new ArrayList<>();
            edge = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) edge[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                edge[start].add(end);
            }

            for (int i = 1; i <= N; i++) {
                if (node[i] == 0) DFS(i);
            }

            outDegree = new int[SCC.size() + 1];
            for (int i = 1; i <= N; i++) {
                for (int y : edge[i]) {
                    if (group[i] != group[y]) {
                        outDegree[group[i]]++;
                    }
                }
            }


            ArrayList<Integer> endPoint = new ArrayList<>();


            for (int i = 0; i < SCC.size(); i++) {
                if (outDegree[i] == 0) {
                    endPoint.add(i);
                }
            }
            if (endPoint.size() == 0) {
                sb.append(" ").append('\n');
                break;
            }

            for (int i = 1; i <= N; i++) {
                if (endPoint.contains(group[i])) sb.append(i).append(" ");
            }

            sb.append('\n');
        }
        System.out.print(sb);
    }
}
