import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int MAX_LENGTH = 100_000;

    private int N;
    private HashMap<Integer, Integer> rowIdxMap = new HashMap<>();
    private HashMap<Integer, Integer> colIdxMap = new HashMap<>();
    private int[] rowCnt = new int[MAX_LENGTH];
    private int[] colCnt = new int[MAX_LENGTH];
    private int res;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        int rowIdx = 0;
        int colIdx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            if (!rowIdxMap.containsKey(row)) {
                rowIdxMap.put(row, rowIdx++);
            }
            rowCnt[rowIdxMap.get(row)]++;

            if (!colIdxMap.containsKey(col)) {
                colIdxMap.put(col, colIdx++);
            }
            colCnt[colIdxMap.get(col)]++;
        }

        for (int i = 0; i < rowIdx; i++) {
            if (rowCnt[i] >= 2) {
                res++;
            }
        }

        for (int i = 0; i < colIdx; i++) {
            if (colCnt[i] >= 2) {
                res++;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
