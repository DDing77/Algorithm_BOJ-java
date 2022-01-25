import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static int order = 0;
    static ArrayList<Integer>[] map;
    static int[] searchOrder;
    static boolean[] isCutVertex;
    static StringBuilder sb;

    static int dfs(int now, boolean isRoot) {
        order++;
        searchOrder[now] = order;
        int rtnLow = order;
        int child = 0;

        for (int next : map[now]) {
            if (searchOrder[next] == 0) {
                child++;
                int low = dfs(next, false);
                if (isRoot == false && low >= searchOrder[now]) {
                    isCutVertex[now] = true;
                }
                rtnLow = Math.min(rtnLow, low);
            } else {
                rtnLow = Math.min(rtnLow, searchOrder[next]);
            }
        }
        if (isRoot == true && child >= 2) {
            isCutVertex[now] = true;
        }
        return rtnLow;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        searchOrder = new int[V + 1];
        isCutVertex = new boolean[V + 1];
        map = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }


    }
}
