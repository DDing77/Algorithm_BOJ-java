import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    int N;
    int[][] coordinates;
    TreeSet<Integer> treeSetX;
    TreeSet<Integer> treeSetY;
    HashMap<Integer, Integer> relativeX;
    HashMap<Integer, Integer> relativeY;
    int[][] compressedBoard;
    int[][] prefixSum;
    int res;

    private int getPrefixSumValue(int x1, int y1, int x2, int y2) {

        return prefixSum[x2][y2] - prefixSum[x2][y1] - prefixSum[x1][y2] + prefixSum[x1][y1];
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        coordinates = new int[N][2];
        treeSetX = new TreeSet<>();
        treeSetY = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            coordinates[i][0] = x;
            coordinates[i][1] = y;
            treeSetX.add(x);
            treeSetY.add(y);
        }

        relativeX = new HashMap<>();
        int count = 0;
        for (int x : treeSetX) {
            relativeX.put(x, count);
            count++;
        }

        relativeY = new HashMap<>();
        count = 0;
        for (int y : treeSetY) {
            relativeY.put(y, count);
            count++;
        }

        int row = relativeX.size();
        int col = relativeY.size();
        compressedBoard = new int[row][col];
        for (int i = 0; i < coordinates.length; i++) {
            compressedBoard[relativeX.get(coordinates[i][0])][relativeY.get(coordinates[i][1])]++;
        }

        prefixSum = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                prefixSum[i][j] = compressedBoard[i - 1][j - 1] + prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1];
            }
        }

        res = Integer.MAX_VALUE;
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                int areaA = getPrefixSumValue(0, 0, i, j);
                int areaB = getPrefixSumValue(0, j, i, col);
                int areaC = getPrefixSumValue(i, j, row, col);
                int areaD = getPrefixSumValue(i, 0, row, j);
                int max = Math.max(areaA, Math.max(areaB, Math.max(areaC, areaD)));
                res = Math.min(res, max);
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
