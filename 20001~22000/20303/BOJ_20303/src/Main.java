import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int K;
    private int[] candies;
    private int[] parents;
    private ArrayList<Group> groupList;
    private int[] dp;

    private int find(int x) {

        if (parents[x] < 0) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    private void union(int x, int y) {

        x = find(x);
        y = find(y);

        if (x == y) {
            return;
        }

        if (parents[x] <= parents[y]) {
            parents[x] += parents[y];
            parents[y] = x;
            candies[x] += candies[y];
            candies[y] = 0;
        } else {
            parents[y] += parents[x];
            parents[x] = y;
            candies[y] += candies[x];
            candies[x] = 0;
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        Arrays.fill(parents, -1);

        candies = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            candies[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        groupList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (candies[i] > 0) {
                groupList.add(new Group(candies[i], parents[i] * -1));
            }
        }

        dp = new int[K];
        for (int i = 0; i < groupList.size(); i++) {
            for (int j = K - 1; j >= groupList.get(i).memberSize; j--) {
                dp[j] = Math.max(dp[j], dp[j - groupList.get(i).memberSize] + groupList.get(i).candiesSum);
            }
        }

        System.out.println(dp[K - 1]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Group {

        int candiesSum;
        int memberSize;

        public Group(int candiesSum, int memberSize) {
            this.candiesSum = candiesSum;
            this.memberSize = memberSize;
        }

        @Override
        public String toString() {
            return "Group{" +
                    "candiesSum=" + candiesSum +
                    ", memberSize=" + memberSize +
                    '}';
        }
    }

}
