import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int[] numbers;
    private int[] treeNodes;

    private int initTD(int start, int end, int nodeNum) {

        if (start == end) {
            return treeNodes[nodeNum] = start;
        }

        int mid = (start + end) >> 1;

        int left = initTD(start, mid, nodeNum * 2);
        int right = initTD(mid + 1, end, nodeNum * 2 + 1);

        if (numbers[left] <= numbers[right]) {
            return treeNodes[nodeNum] = left;
        } else {
            return treeNodes[nodeNum] = right;
        }
    }

    private int updateTD(int start, int end, int nodeNum, int targetNodeIdx) {

        if (start == end || targetNodeIdx < start || end < targetNodeIdx) {
            return treeNodes[nodeNum];
        }

        int mid = (start + end) >> 1;

        int left = updateTD(start, mid, nodeNum * 2, targetNodeIdx);
        int right = updateTD(mid + 1, end, nodeNum * 2 + 1, targetNodeIdx);

        if (numbers[left] <= numbers[right]) {
            return treeNodes[nodeNum] = left;
        } else {
            return treeNodes[nodeNum] = right;
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        numbers = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        treeNodes = new int[4 * N + 1];
        initTD(1, N, 1);

        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if (op == 1) {
                int targetNodeIdx = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                numbers[targetNodeIdx] = value;
                updateTD(1, N, 1, targetNodeIdx);
            } else {
                sb.append(treeNodes[1]).append('\n');
            }
        }

        System.out.print(sb);

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
