import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private class Node {
        int nodeNum;
        int depth;

        public Node(int nodeNum, int depth) {
            this.nodeNum = nodeNum;
            this.depth = depth;
        }
    }

    private int n, m;
    private ArrayList<Integer>[] edges;
    private boolean[] isVisited;
    private int res;

    public void execBFS() {
        isVisited = new boolean[n + 1];
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(1, 0));
        isVisited[1] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();

            if (cur.depth == 2) {
                return;
            }

            for (int next : edges[cur.nodeNum]) {
                if (isVisited[next]) {
                    continue;
                }

                res++;
                isVisited[next] = true;
                que.add(new Node(next, cur.depth + 1));
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        edges = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            edges[from].add(to);
            edges[to].add(from);
        }

        res = 0;
        execBFS();

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
