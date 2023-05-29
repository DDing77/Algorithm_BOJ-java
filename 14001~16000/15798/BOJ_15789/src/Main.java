import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    private int N;
    private int M;
    private int[] parents;
    private int C;
    private int H;
    private int K;
    private ArrayList<Kingdom> kingdoms;
    private int res;

    private class Kingdom implements Comparable<Kingdom> {
        int number;
        int rank;

        public Kingdom(int number, int rank) {
            this.number = number;
            this.rank = rank;
        }

        @Override
        public int compareTo(Kingdom o) {
            return rank - o.rank;
        }
    }

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

        if (parents[a] <= parents[b]) {
            parents[a] += parents[b];
            parents[b] = a;
        } else {
            parents[b] += parents[a];
            parents[a] = b;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        Arrays.fill(parents, -1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            union(from, to);
        }

        kingdoms = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (parents[i] < 0) {
                kingdoms.add(new Kingdom(i, parents[i]));
            }
        }

        Collections.sort(kingdoms);

        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        res = -parents[find(C)];

        for (int i = 0; i < kingdoms.size(); i++) {
            if (K == 0) {
                break;
            }
            if (find(C) == find(kingdoms.get(i).number)) {
                continue;
            }
            if (find(H) == find(kingdoms.get(i).number)) {
                continue;
            }
            res -= kingdoms.get(i).rank;
            K--;
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
