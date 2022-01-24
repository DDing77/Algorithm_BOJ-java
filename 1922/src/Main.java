import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M, cnt = 0, sum = 0;
    static int[] parent;
    static ArrayList<Edge> list;
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;
        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

    static void union(int a, int b) {
        int a_parent = find(a);
        int b_parent = find(b);

        parent[a_parent] = b_parent;
    }

    static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);

    }

    static void solution() {
        for (int i = 0; i < M; i++) {

            int aNode = list.get(i).start;
            int bNode = list.get(i).end;
            int weight = list.get(i).weight;
            if (find(aNode) == find(bNode)) continue;
            union(aNode, bNode);
            sum += weight;
        }
        System.out.println(sum);
        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        parent = new int[N+1];
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }
        for(int i=0; i<M; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.add(new Edge(start, end, weight));
        }
        Collections.sort(list);
//        for(int i=0; i<M; i++) {
//            System.out.println(list.get(i).weight);
//        }
        solution();
    }
}
