import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static class Rank implements Comparable<Rank> {
        int x;
        int y;
        int z;

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setZ(int z) {
            this.z = z;
        }

        public Rank() {

        }

        ;

        public Rank(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Rank o) {
            return x - o.x;
        }
    }

    static int N;
    static Rank[] ranks;
    static int[] tree;

    static int updateTD(int start, int end, int idx, int value, int nodeNum) {
        if (idx < start || idx > end) return tree[nodeNum];
        if (start == end) return tree[nodeNum] = value;
        int mid = (start + end) >> 1;

        return tree[nodeNum] = Math.min(
                updateTD(start, mid, idx, value, nodeNum * 2),
                updateTD(mid + 1, end, idx, value, nodeNum * 2 + 1)
        );
    }

    static int queryTD(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (start > queryRight || end < queryLeft) return Integer.MAX_VALUE;
        if (queryLeft <= start && end <= queryRight) return tree[nodeNum];

        int mid = (start + end) >> 1;
        return Math.min(
                queryTD(start, mid, queryLeft, queryRight, nodeNum * 2),
                queryTD(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1)
        );
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        ranks = new Rank[N + 1];

        int startLeaf = 1;
        while (startLeaf < N) startLeaf *= 2;
        int length = startLeaf * 2;

        tree = new int[length + 1];
        Arrays.fill(tree, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) ranks[i] = new Rank();

        ranks[0].setX(0);
        ranks[0].setY(0);
        ranks[0].setZ(0);

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int input = Integer.parseInt(st.nextToken());
            ranks[input].x = i;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int input = Integer.parseInt(st.nextToken());
            ranks[input].y = i;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int input = Integer.parseInt(st.nextToken());
            ranks[input].z = i;
        }

        Arrays.sort(ranks);

//        for(int i=0; i<=N; i++) {
//            System.out.println(ranks[i].x + ", " + ranks[i].y + ", " + ranks[i].z);
//        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (queryTD(1, N, 1, ranks[i].y, 1) > ranks[i].z) ans++;
            updateTD(1, N, ranks[i].y, ranks[i].z, 1);
        }

        System.out.println(ans);
    }
}
