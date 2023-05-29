import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private int N;
    private int M;
    private int[] rooms;
    private int res;

    private class Info implements Comparable<Info> {
        int start;
        int end;

        public Info(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Info o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }

            return this.start - o.start;
        }
    }

    public int find(int x) {
        if (rooms[x] < 0) {
            return x;
        }

        return rooms[x] = find(rooms[x]);
    }

    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a == b) {
            return;
        }

        if (rooms[a] <= rooms[b]) {
            rooms[a] += rooms[b];
            rooms[b] = a;
        } else {
            rooms[b] += rooms[a];
            rooms[a] = b;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Info> pq = new PriorityQueue<>();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        rooms = new int[N + 1];
        Arrays.fill(rooms, -1);

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            pq.add(new Info(start, to));
        }

        int last = 0;
        int left;
        int right;
        while (!pq.isEmpty()) {
            Info cur = pq.poll();

            left = cur.start;
            right = cur.end;

            if (last > cur.start) {
                left = last;
            }

            for (int i = left; i <= right; i++) {
                union(left, i);
            }

            if (right > last) {
                last = right;
            }
        }

        res = 0;
        for (int i = 1; i <= N; i++) {
            if (rooms[i] < 0) {
                res++;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
