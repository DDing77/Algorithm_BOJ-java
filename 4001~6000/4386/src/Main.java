import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int n;

    static class Point {
        double x;
        double y;
        int num;

        public Point(double x, double y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    static class Edge implements Comparable<Edge> {
        int A;
        int B;
        double weight;

        public Edge(int A, int B, double weight) {
            this.A = A;
            this.B = B;
            this.weight = weight;
        }


        @Override
        public int compareTo(Edge o) {
            if (weight < o.weight) {
                return -1;
            }
            return 1;
        }
    }

    static Point[] points;
    static ArrayList<Edge> edges;
    static int[] parent;
    static double res;

    public static double getDistance(Point A, Point B) {
        return Math.sqrt(Math.pow(A.x - B.x, 2) + Math.pow(A.y - B.y, 2));
    }

    public static int find(int x) {
        if (parent[x] < 0) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (parent[a] < parent[b]) {
            parent[a] += parent[b];
            parent[b] = a;
        } else {
            parent[b] += parent[a];
            parent[a] = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        points = new Point[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            points[i] = new Point(x, y, i);
        }

        edges = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(points[i].num, points[j].num, getDistance(points[i], points[j])));
            }
        }
        Collections.sort(edges);

        parent = new int[n];
        Arrays.fill(parent, -1);

        res = 0;
        int cnt = 0;
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);

            if (find(edge.A) != find(edge.B)) {
                res += edge.weight;
                union(edge.A, edge.B);
                cnt++;
            }

            if (cnt == n - 1) break;
        }

        System.out.println(res);
    }
}
