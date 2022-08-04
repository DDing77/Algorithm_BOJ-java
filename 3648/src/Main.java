import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] discover;
    static boolean[] isFinished;
    static int[] nodeToSCC;
    static int idx;
    static int sccIdx;
    static ArrayList<Integer>[] edges;
    static ArrayList<ArrayList<Integer>> SCC;
    static Stack<Integer> stack;

    static int validate(int x) {
        if (0 < x && x < n + 1) return x;
        else return -x + n;
    }

    static int dfs(int x) {
        discover[x] = ++idx;
        stack.push(x);

        int root = discover[x];

        for (int next : edges[x]) {
            if (discover[next] == 0) root = Math.min(root, dfs(next));
            else if (!isFinished[next]) root = Math.min(root, discover[next]);
        }

        if (root == discover[x]) {
            while (true) {
                int top = stack.pop();
                nodeToSCC[top] = sccIdx + 1;
                isFinished[top] = true;
                if (top == x) break;
            }
            sccIdx++;
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            String input = br.readLine();
            if (input == null) break;
            st = new StringTokenizer(input, " ");

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            discover = new int[n * 2 + 1];
            nodeToSCC = new int[n * 2 + 1];
            isFinished = new boolean[n * 2 + 1];
            edges = new ArrayList[n * 2 + 1];
            for (int i = 0; i < n * 2 + 1; i++) edges[i] = new ArrayList<>();
            SCC = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                edges[validate(-a)].add(validate(b));
                edges[validate(-b)].add(validate(a));
            }
            edges[validate(-1)].add(1);

            idx = 0;
            sccIdx = 0;
            stack = new Stack<>();
            for (int i = 1; i <= n; i++) {
                if (discover[i] == 0) dfs(i);
            }

//            for(int i=0; i<=sccIdx; i++) SCC.add(new ArrayList<>());
            boolean flag = false;
            for (int i = 1; i <= n; i++) {
                if (nodeToSCC[i] == nodeToSCC[i + n]) {
                    flag = true;
                    break;
                }
            }
            if (flag) sb.append("no").append('\n');
            else sb.append("yes").append('\n');
        }
        System.out.print(sb);
    }
}