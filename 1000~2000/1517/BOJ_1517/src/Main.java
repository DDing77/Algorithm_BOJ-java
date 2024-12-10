import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] A;
    private int[] treeNodes;
    private long res;

    private int updateQuery(int start, int end, int nodeNum, int idx) {

        if (start == end) {
            return treeNodes[nodeNum] = 1;
        }

        int mid = (start + end) >> 1;

        if (idx <= mid) {
            return treeNodes[nodeNum] = updateQuery(start, mid, nodeNum * 2, idx) + treeNodes[nodeNum * 2 + 1];
        } else {
            return treeNodes[nodeNum] = treeNodes[nodeNum * 2] + updateQuery(mid + 1, end, nodeNum * 2 + 1, idx);
        }
    }

    private int sumQuery(int start, int end, int left, int right, int nodeNum) {

        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && end <= right) {
            return treeNodes[nodeNum];
        }

        int mid = (start + end) >> 1;

        return sumQuery(start, mid, left, right, nodeNum * 2)
                + sumQuery(mid + 1, end, left, right, nodeNum * 2 + 1);
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        treeNodes = new int[N * 4 + 1];
        HashMap<Integer, Queue<Integer>> idxTable = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (!idxTable.containsKey(A[i])) {
                idxTable.put(A[i], new ArrayDeque<>());
                idxTable.get(A[i]).add(i);
            } else {
                idxTable.get(A[i]).add(i);
            }
        }

        Arrays.sort(A);
        res = 0L;
        for (int i = 0; i < N; i++) {
            int targetIdx = idxTable.get(A[i]).poll();
            res += sumQuery(0, N - 1, targetIdx + 1, N - 1, 1);
            updateQuery(0, N - 1, 1, targetIdx);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
