import java.io.*;
import java.util.*;

public class Main {
    static int N, id;
    static ArrayList<ArrayList<Integer>> SCC;
    static ArrayList<Integer>[] edge;
    static int[] node;
    static boolean[] finished;
    static Stack<Integer> stack;

    static int validate(int n) {
        if (0 < n && n < N + 1)
            return n;
        return -n + N;
    }

    static int DFS(int idx) {
        node[idx] = ++id;
        stack.add(idx);
        int result = node[idx];

        for (int next : edge[idx]) {
            if (node[next] == 0) result = Math.min(result, DFS(next));
            else if (!finished[next]) result = Math.min(result, node[next]);
        }

        if (result == node[idx]) {
            ArrayList<Integer> scc = new ArrayList<>();
            boolean[] check = new boolean[N + 1];
            while (!stack.isEmpty()) {
                int top = stack.pop();
                int temp = validate(top);
                scc.add(top);

                if (temp < 0)
                    temp *= -1;
                if (check[temp])
                    return -1;

                check[temp] = true;
                finished[top] = true;

                if (top == idx)
                    break;
            }
            SCC.add(scc);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        edge = new ArrayList[2 * N + 1];
        node = new int[2 * N + 1];
        finished = new boolean[2 * N + 1];
        stack = new Stack<>();
        SCC = new ArrayList<>();

        for (int i = 0; i < 2 * N + 1; i++) {
            edge[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            edge[validate(-u)].add(validate(v));
            edge[validate(-v)].add(validate(u));
        }

        boolean flag = true;
        for (int i = 1; i < 2 * N + 1; i++) {
            if (node[i] == 0) {
                if (DFS(i) == -1) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag)
            sb.append('1');
        else
            sb.append('0');
        System.out.println(sb);
    }
}