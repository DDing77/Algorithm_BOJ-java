import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int INF = 111_111;

    private int N;
    private int[] numbers;
    private int[] sizes;
    private boolean[] isCent;
    private List<Integer>[] edges;
    private int[] resMinDistance;
    private int[] tempMinDistance;
    private int res;

    private int getSize(int pre, int cur) {
        sizes[cur] = 1;
        for (int next : edges[cur]) {
            if (next != pre && !isCent[next]) {
                sizes[cur] += getSize(cur, next);
            }
        }
        return sizes[cur];
    }

    private int getCentroid(int pre, int cur, int size) {
        for (int next : edges[cur]) {
            if (pre != next && !isCent[next] && sizes[next] > size / 2) {
                return getCentroid(cur, next, size);
            }
        }
        return cur;
    }

    private int dnq(int curNodeNum) {
        int size = getSize(-1, curNodeNum);
        int centroid = getCentroid(-1, curNodeNum, size);

        isCent[curNodeNum] = true;
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        res = INF;

    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
