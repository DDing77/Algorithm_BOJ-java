import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    int N;
    int Q;
    int[] parents;
    Line[] lines;

    public int find(int x) {
        if (parents[x] < 0) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a == b) {
            return;
        }

        if (parents[a] < parents[b]) {
            parents[a] += parents[b];
            parents[b] = a;
        } else {
            parents[b] += parents[a];
            parents[a] = b;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        lines = new Line[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
        }

        Arrays.sort(lines);

        parents = new int[N];
        Arrays.fill(parents, -1);

        Line cur = lines[0];
        for (int i = 1; i < N; i++) {
            if (cur.start <= lines[i].start && lines[i].start <= cur.end) {
                union(cur.idx, lines[i].idx);
                if (cur.end <= lines[i].end) {
                    cur = lines[i];
                }
                continue;
            }
            cur = lines[i];
        }

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            if (find(Integer.parseInt(st.nextToken()) - 1) == find(Integer.parseInt(st.nextToken()) - 1)) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static class Line implements Comparable<Line> {
        int start;
        int end;
        int height;
        int idx;

        public Line(int start, int end, int height, int idx) {
            this.start = start;
            this.end = end;
            this.height = height;
            this.idx = idx;
        }

        @Override
        public int compareTo(Line o) {
            return this.start - o.start;
        }
    }
}
