import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static class Circle {
        int x;
        int y;
        int r;

        public Circle(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    static Circle[] circles;
    static int[] parent;
    static int T;
    static int N, x, y;
    static int R;

    static int find(int x) {
        if (parent[x] < 0) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a == b) return;
        if (parent[a] < parent[b]) {
            parent[a] += parent[b];
            parent[b] = a;
        } else {
            parent[b] += parent[a];
            parent[a] = b;
        }
    }

    static boolean isMatch(Circle c1, Circle c2) {
        double maxDistance = c1.r + c2.r;
        double diff = Math.sqrt(Math.pow(Math.abs(c1.x - c2.x), 2) + Math.pow(Math.abs(c1.y - c2.y), 2));

        if (diff <= maxDistance) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            circles = new Circle[N + 1];
            parent = new int[N + 1];
            Arrays.fill(parent, -1);

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                R = Integer.parseInt(st.nextToken());

                circles[i] = new Circle(x, y, R);
                if (i != 1) {
                    for (int j = 1; j < i; j++) {
                        if (isMatch(circles[j], circles[i])) {
                            union(j, i);
                        }
                    }
                }
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <= N; i++) set.add(find(i));

            sb.append(set.size()).append('\n');
        }
        System.out.print(sb);
    }
}
