import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int v = 52;
    static int[][] flow, capacitiy;

    static int atoi(char c) {
        if('A' <= c && c <= 'Z') return c- 'A';
        else if('a' <= c && c<= 'z') return c-'A'-6;
        return -1;
    }

    static void maxFlow(int src, int sink) {
        int totalFlow = 0;
        int[] parent = new int[v];
        Queue<Integer> que;
        while(true) {
            Arrays.fill(parent, -1);
            que = new LinkedList<>();

            parent[src] = src;
            que.add(src);

            while(!que.isEmpty() && parent[sink] == -1) {
                int cur = que.poll();
                for(int next =0; next<v; next++) {
                    if(capacitiy[cur][next] - flow[cur][next] > 0 && parent[next] == -1) {
                        que.add(next);
                        parent[next] = cur;
                    }
                }
            }

            if(parent[sink] == -1) break;

            int amount = Integer.MAX_VALUE;
            for(int i = sink; i!=src; i=parent[i]) {
                amount = Math.min(capacitiy[parent[i]][i] - flow[parent[i]][i], amount);
            }

            for(int i= sink; i!=src; i=parent[i]) {
                flow[parent[i]][i] += amount;
                flow[i][parent[i]] -= amount;
            }

            totalFlow += amount;
        }
        System.out.println(totalFlow);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n =  Integer.parseInt(br.readLine());

        flow = new int[v][v];
        capacitiy = new int[v][v];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = atoi(st.nextToken().charAt(0));
            int end = atoi(st.nextToken().charAt(0));
            int cost = Integer.parseInt(st.nextToken());

            capacitiy[start][end] += cost;
            capacitiy[end][start] += cost;
        }

        maxFlow(0,25);
    }
}
