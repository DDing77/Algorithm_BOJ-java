import java.io.*;
import java.util.*;

public class Main {
    static int N, V, num;
    static ArrayList<ArrayList<Integer>> graph, SCC;
    static int[] parent, compare, CNF;
    static boolean[] visit;
    static Stack<Integer> stack;

    private static int validate(int n) {
        return (0 < n && n < N + 1) ? n : -n + N;
    }

    private static String setCNF() {
        for (int i = V - 1; i > -1; i--) {
            for (int j : SCC.get(i)) {
                int now = Math.abs(validate(j));
                if (CNF[now] == -1) {
                    if (j > N) {
                        CNF[now] = 1;
                    } else {
                        CNF[now] = 0;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(CNF[i]).append(' ');
        }
        return sb.toString();
    }

    private static int SCC(int idx) {
        parent[idx] = ++num;
        stack.push(idx);

        int root = parent[idx];
        for (int next : graph.get(idx)) {
            if (parent[next] == 0)
                root = Math.min(root, SCC(next));
            else if (!visit[next])
                root = Math.min(root, parent[next]);
        }

        if (root == parent[idx]) {
            ArrayList<Integer> tmp = new ArrayList<>();
            while (!stack.isEmpty()) {
                int top = stack.pop();
                tmp.add(top);
                visit[top] = true;
                compare[top] = V;

                if (top == idx)
                    break;
            }
            V++;
            SCC.add(tmp);
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[2 * N + 1];
        compare = new int[2 * N + 1];
        visit = new boolean[2 * N + 1];
        stack = new Stack<>();
        num = 0;
        V = 0;
        CNF = new int[2 * N + 1];
        Arrays.fill(CNF, -1);

        graph = new ArrayList<>();
        SCC = new ArrayList<>();
        for (int i = 0; i < 2 * N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(validate(-u)).add(validate(v));
            graph.get(validate(-v)).add(validate(u));
        }

        for (int i = 1; i < 2 * N + 1; i++) {
            if (!visit[i]) {
                SCC(i);
            }
        }
        int sts = 1;
        for (int i = 1; i < N + 1; i++) {
            if (compare[i] == compare[i + N])
                sts = 0;
        }

        bw.write(sts + "\n");
        if (sts == 1)
            bw.write(setCNF() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}