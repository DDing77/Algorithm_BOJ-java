import javax.management.StringValueExp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dir = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };

    private int T;
    private int[][] board;
    private Map<String, Integer> cache;

    private String getBitStatus(int[][] board) {

        StringBuilder bitStatus = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                bitStatus.append(board[i][j]);
            }
        }

        return bitStatus.toString();
    }

    private boolean check(String bitStatus) {

        char tareget = bitStatus.charAt(0);
        for (int i = 1; i < bitStatus.length(); i++) {
            if (tareget != bitStatus.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private int execBFS(String initBitStatus) {

        Queue<String> que = new ArrayDeque<>();
        que.add(initBitStatus);
        cache.put(initBitStatus, 0);

        while (!que.isEmpty()) {
            String curBitStatus = que.poll();

            if (check(curBitStatus)) {
                return cache.get(curBitStatus);
            }

            for (int[] next : dir) {
                StringBuilder copyBitStatus = new StringBuilder(String.valueOf(curBitStatus));
                for (int idx : next) {
                    if (copyBitStatus.charAt(idx) == '1') {
                        copyBitStatus.setCharAt(idx, '0');
                    } else {
                        copyBitStatus.setCharAt(idx, '1');
                    }
                }
                if (cache.containsKey(copyBitStatus.toString())) {
                    continue;
                }

                cache.put(copyBitStatus.toString(), cache.get(curBitStatus) + 1);
                que.add(copyBitStatus.toString());
            }
        }

        return -1;
    }

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            board = new int[3][3];
            for (int i = 0; i < 3; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    char val = st.nextToken().charAt(0);
                    if (val == 'T') {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                }
            }

            cache = new HashMap<>();
            String initStatus = getBitStatus(board);
            sb.append(execBFS(initStatus)).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
