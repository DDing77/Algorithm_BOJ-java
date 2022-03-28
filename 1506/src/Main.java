import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int id;
    static long res = 0;
    static int[] city;
    static int[] node;
    static int[] group;
    static boolean[] finished;
    static ArrayList<ArrayList<Integer>> SCC;
    static ArrayList<Integer>[] edge;
    static Stack<Integer> stack;

    static int DFS(int x) {
        node[x] = id++;
        stack.push(x);
        int result = node[x];
        for (int next : edge[x]) {
            if (node[next] == 0) result = Math.min(result, DFS(next));
            else if (!finished[next]) result = Math.min(result, node[next]);
        }

        if (node[x] == result) {
            ArrayList<Integer> scc = new ArrayList<>();
            int min = Integer.MAX_VALUE;
            while (true) {
                int top = stack.pop();
                scc.add(top);
                finished[top] = true;
                group[top] = SCC.size();
                min = Math.min(min, city[top]);
                if (top == x) break;
            }
            SCC.add(scc);
            res += min;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        city = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) city[i] = Integer.parseInt(st.nextToken());

        node = new int[N + 1];
        group = new int[N + 1];
        finished = new boolean[N + 1];
        stack = new Stack<>();
        SCC = new ArrayList<>();
        edge = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) edge[i] = new ArrayList<>();


        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                if (input.charAt(j) == '1') {
                    edge[i].add(j + 1);
                }
            }
        }

        id = 1;
        for (int i = 1; i <= N; i++) {
            if (node[i] == 0) DFS(i);
        }
        System.out.println(res);
    }
}
