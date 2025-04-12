import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int MAX_SIZE = 100;

    private int r;
    private int c;
    private int k;

    private int[][] board;
    private int curMaxRow = 3;
    private int curMaxCol = 3;

    private int res;

    private List<OrderResult> getRowOrderResults(int rowIdx) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= curMaxCol; i++) {
            if (board[rowIdx][i] == 0) {
                continue;
            }
            map.put(board[rowIdx][i], map.getOrDefault(board[rowIdx][i], 0) + 1);
        }

        List<OrderResult> orderResults = new ArrayList<>();
        for (Map.Entry<Integer, Integer> orderedEle : map.entrySet()) {
            orderResults.add(new OrderResult(orderedEle.getKey(), orderedEle.getValue()));
        }

        Collections.sort(orderResults);
        return orderResults;
    }

    private void updateRow(List<OrderResult> orderResults, int rowIdx) {
        for (int i = 0; i < orderResults.size(); i++) {
            OrderResult orderResult = orderResults.get(i);
            board[rowIdx][1 + 2 * i] = orderResult.number;
            board[rowIdx][2 + 2 * i] = orderResult.count;
        }

        if (orderResults.size() * 2 < curMaxCol) {
            for (int i = orderResults.size() * 2 + 1; i <= curMaxCol; i++) {
                board[rowIdx][i] = 0;
            }
        }
    }

    private void execRow() {
        int maxCol = curMaxCol;
        for (int i = 1; i <= curMaxRow; i++) {
            List<OrderResult> orderResults = getRowOrderResults(i);
            maxCol = Math.max(maxCol, orderResults.size() * 2);
            updateRow(orderResults, i);
        }
        curMaxCol = Math.min(maxCol, MAX_SIZE);
    }

    private List<OrderResult> getColOrderResults(int colIdx) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= curMaxRow; i++) {
            if (board[i][colIdx] == 0) {
                continue;
            }
            map.put(board[i][colIdx], map.getOrDefault(board[i][colIdx], 0) + 1);
        }

        List<OrderResult> orderResults = new ArrayList<>();
        for (Map.Entry<Integer, Integer> orderedEle : map.entrySet()) {
            orderResults.add(new OrderResult(orderedEle.getKey(), orderedEle.getValue()));
        }

        Collections.sort(orderResults);
        return orderResults;
    }

    private void updateCol(List<OrderResult> orderResults, int colIdx) {
        for (int i = 0; i < orderResults.size(); i++) {
            OrderResult orderResult = orderResults.get(i);
            board[1 + 2 * i][colIdx] = orderResult.number;
            board[2 + 2 * i][colIdx] = orderResult.count;
        }

        if (orderResults.size() * 2 < curMaxRow) {
            for (int i = orderResults.size() * 2 + 1; i <= curMaxRow; i++) {
                board[i][colIdx] = 0;
            }
        }
    }

    private void execCol() {
        int maxRow = curMaxRow;
        for (int i = 1; i <= curMaxCol; i++) {
            //정렬 결과 가져오기
            List<OrderResult> orderResults = getColOrderResults(i);
            maxRow = Math.max(maxRow, orderResults.size() * 2);
            //배열에 결과 채우기
            updateCol(orderResults, i);
        }
        curMaxRow = Math.min(maxRow, MAX_SIZE);
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[MAX_SIZE + 1][MAX_SIZE + 1];
        for (int i = 1; i <= curMaxRow; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= curMaxCol; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while (board[r][c] != k) {
            if (curMaxRow >= curMaxCol) {
                execRow();
            } else {
                execCol();
            }

            res++;
            if (res > 100) {
                res = -1;
                break;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class OrderResult implements Comparable<OrderResult> {
        int number;
        int count;

        public OrderResult(int number, int count) {
            this.number = number;
            this.count = count;
        }

        @Override
        public int compareTo(OrderResult o) {
            if (this.count == o.count) {
                return this.number - o.number;
            }
            return this.count - o.count;
        }
    }
}
