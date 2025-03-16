import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private Map<Integer, List<Integer>> map;
    private int[] nodes;
    private long res;

    private long query(int idx) {
        long cnt = 0L;
        while (idx > 0) {
            cnt += nodes[idx];
            idx -= idx & -idx;
        }
        return cnt;
    }

    private void update(int idx) {
        while (idx <= N) {
            nodes[idx]++;
            idx += idx & -idx;
        }
    }

    private void solution() throws IOException {
//        st = new StringTokenizer(br.readLine());
        N = read();
        M = read();

        map = new HashMap<>();
        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
            int x = read();
            int y = read();

            map.computeIfAbsent(x, list -> new ArrayList<>()).add(y);
        }

        List<Integer> xList = new ArrayList<>(map.keySet());
        xList.sort(Integer::compareTo);

        nodes = new int[N + 1];

        int curIdx = 0;
        res = 0L;
        for (int x : xList) {
            for (int y : map.get(x)) {
                res += (curIdx++) - query(y);
                update(y);
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    private static int read() throws IOException {
        int n = 0;
        int i;
        while ((i = System.in.read()) >= '0') {
            n = (n<<3) + (n<<1) + (i&15);
        }
        return n;
    }
}
