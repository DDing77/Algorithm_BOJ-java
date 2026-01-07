import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int R;
    private int C;
    private int[][] board;
    private int T;
    private List<Integer> temp = new ArrayList<>();
    private List<Integer> filteredList = new ArrayList<>();
    private int res;

    private void filter(int x, int y) {
        temp.clear();
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                temp.add(board[i][j]);
            }
        }

        Collections.sort(temp);
        filteredList.add(temp.get(4));
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < R - 2; i++) {
            for (int j = 0; j < C - 2; j++) {
                filter(i, j);
            }
        }

        for (Integer value : filteredList) {
            if (value >= T) {
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
