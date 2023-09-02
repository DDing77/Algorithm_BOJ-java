import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    int N;
    int[][] board;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][6];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxStudentId = 1;
        int maxStudentCnt = 0;
        int cnt;
        for (int i = 1; i <= N; i++) {
            Set<Integer> friend = new HashSet<>();
            for (int j = 1; j <= 5; j++) {
                for (int k = 1; k <= N; k++) {
                    if (k == i) {
                        continue;
                    }
                    if (board[k][j] == board[i][j]) {
                        friend.add(k);
                    }
                }
            }
            if (maxStudentCnt < friend.size()) {
                maxStudentId = i;
                maxStudentCnt = friend.size();
            }
        }
        System.out.println(maxStudentId);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
