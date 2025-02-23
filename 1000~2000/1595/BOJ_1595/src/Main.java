import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private HashMap<Integer, List<Edge>> edges;
    private int resMaxDistance;

    private int execBFS(int startNodeNum) {

        int res = startNodeNum;

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[] { startNodeNum, 0 });

        Set<Integer> isVisited = new HashSet<>();
        isVisited.add(startNodeNum);

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[1] > resMaxDistance) {
                resMaxDistance = cur[1];
                res = cur[0];
            }

            for (Edge edge : edges.get(cur[0])) {
                if (!isVisited.contains(edge.to)) {
                    isVisited.add(edge.to);
                    que.add(new int[] { edge.to, cur[1] + edge.distance });
                }
            }
        }

        return res;
    }

    private void solution() throws IOException {

        edges = new HashMap<>();

        int from = -1;
        int to = -1;
        int distance = -1;
        while (true) {

            try {
                st = new StringTokenizer(br.readLine());

                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                distance = Integer.parseInt(st.nextToken());

                if (!edges.containsKey(from)) {
                    edges.put(from, new ArrayList<>());
                }

                if (!edges.containsKey(to)) {
                    edges.put(to, new ArrayList<>());
                }

            } catch (Exception e) {
                break;
            }
            edges.get(from).add(new Edge(to, distance));
            edges.get(to).add(new Edge(from, distance));
        }

        if (from == -1) {
            System.out.println("0");
            return;
        }

        int firstNode = execBFS(from);
        execBFS(firstNode);

        System.out.println(resMaxDistance);

    }

    public static void main(String[] arsgs) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Edge {

        int to;
        int distance;

        public Edge(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }
}