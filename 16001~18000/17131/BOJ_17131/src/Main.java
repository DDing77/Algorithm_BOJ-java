import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static final int MOD = 1_000_000_007;

    private int N;
    private List<Coordi> coordiList;
    private int[] nodes;
    private long res;

    private int query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryRight < start || end < queryLeft) {
            return 0;
        }

        if (queryLeft <= start && end <= queryRight) {
            return nodes[nodeNum];
        }

        int mid = (start + end) >> 1;
        return query(start, mid, queryLeft, queryRight, nodeNum << 1)
                + query(mid + 1, end, queryLeft, queryRight, nodeNum << 1 | 1);
    }

    private void update(int start, int end, int targetIdx, int nodeNum) {
        if (targetIdx < start || end < targetIdx) {
            return;
        }

        nodes[nodeNum]++;

        if (start == end) {
            return;
        }

        int mid = (start + end) >> 1;
        update(start, mid, targetIdx, nodeNum << 1);
        update(mid + 1, end, targetIdx, nodeNum << 1 | 1);
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        coordiList = new ArrayList<Coordi>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coordiList.add(new Coordi(x, y));
        }

        coordiList.sort(Comparator.comparingInt(o -> o.x));
        int sparseCnt = 1;
        for (int i = 1; i < coordiList.size(); i++) {
            if (coordiList.get(i).x != coordiList.get(i - 1).x) {
                sparseCnt++;
            }
            coordiList.get(i).sparseIdx = sparseCnt;
        }

        coordiList.sort((o1, o2) -> {
            if (o1.y == o2.y) {
                return Integer.compare(o1.sparseIdx, o2.sparseIdx);
            }
            return Integer.compare(o2.y, o1.y);
        });

        nodes = new int[sparseCnt * 4];
        List<Coordi> groupList = new ArrayList<>();
        int idx = 0;
        while (idx < coordiList.size()) {
            groupList.clear();
            int currentY = coordiList.get(idx).y;
            groupList.add(coordiList.get(idx));
            while (idx + 1 < coordiList.size() && currentY == coordiList.get(idx + 1).y) {
                idx++;
                groupList.add(coordiList.get(idx));
            }

            for (Coordi coordi : groupList) {
                int leftRes = query(0, sparseCnt, 1, coordi.sparseIdx - 1, 1);
                int rightRes = query(0, sparseCnt, coordi.sparseIdx + 1, sparseCnt, 1);
                res += (long) leftRes * rightRes;
                res %= MOD;
            }
            for (Coordi coordi : groupList) {
                update(0, sparseCnt, coordi.sparseIdx, 1);
            }
            idx++;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Coordi {

        int x;
        int y;
        int sparseIdx = 1;

        public Coordi(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
