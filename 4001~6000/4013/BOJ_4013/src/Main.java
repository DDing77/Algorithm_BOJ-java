import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, S, P;
    static int idx;
    static int sccIdx;
    static ArrayList<ArrayList<Integer>> SCC;
    static int[] node;
    static int[] atm;
    static boolean[] rest;
    static int[] nodeToSCC;
    static boolean[] isFinished;
    static ArrayList<Integer>[] edges;
    static Stack<Integer> stack;
    static int[] total_a_SCC;
    static int[] dp;

    static int dfs(int x) {
        node[x] = ++idx;
        stack.push(x);

        int result = node[x];

        for(int next : edges[x]) {
            if(node[next] == 0) result = Math.min(result, dfs(next));
            else if(!isFinished[next]) result = Math.min(result, node[next]);
        }

        if(result == node[x]) {
            while (true) {
                int top = stack.pop();
                isFinished[top] = true;
                nodeToSCC[top] = sccIdx + 1;
                if(top == x) break;
            }
            sccIdx++;
        }
        return result;
    }

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        dp[nodeToSCC[S]] = total_a_SCC[nodeToSCC[S]];
        que.add(nodeToSCC[S]);

        while(!que.isEmpty()) {
            int cur = que.poll();

            for(int next : SCC.get(cur)) {
                if(dp[next] < dp[cur] + total_a_SCC[next]) {
                    dp[next] = dp[cur] + total_a_SCC[next];
                    que.add(next);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N+1];
        for(int i=0; i<=N; i++) edges[i] = new ArrayList<>();
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            edges[start].add(end);
        }

        atm = new int[N+1];
        for(int i=1; i<=N; i++) atm[i] = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        rest = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=P; i++) rest[Integer.parseInt(st.nextToken())] = true;
        idx = 0;
        sccIdx = 0;
        node = new int[N+1];
        isFinished = new boolean[N+1];
        nodeToSCC = new int[N+1];
        stack = new Stack<>();
        for(int i=1; i<=N; i++) {
            if(node[i] == 0 ) dfs(i);
        }

        total_a_SCC = new int[sccIdx+1];
        SCC = new ArrayList<>();
        for(int i=0; i<=sccIdx; i++) SCC.add(new ArrayList<>());

        for(int i=1; i<=N; i++) {
            total_a_SCC[nodeToSCC[i]] += atm[i];
            for(int  next : edges[i]) {
                if(nodeToSCC[i] != nodeToSCC[next]) SCC.get(nodeToSCC[i]).add(nodeToSCC[next]);
            }
        }

        dp = new int[sccIdx +1];
        bfs();

        int res = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++) {
            if(rest[i]) res = Math.max(res, dp[nodeToSCC[i]]);
        }
        System.out.println(res);

//        System.out.println("=====");
//        System.out.println(Arrays.toString(total_a_SCC));
    }
}
