import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int N;
    private int[][] board;
    private HashMap<Integer, ArrayList<Integer>> myFriends;
    private int res;

    private void findLocation(int studentNum) {

        ArrayList<int[]> candi = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0) {
                    continue;
                }

                int emptyCnt = 0;
                int friendCnt = 0;
                for (int k = 0; k < dir.length; k++) {
                    int nX = i + dir[k][0];
                    int nY = j + dir[k][1];

                    if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
                        continue;
                    }

                    if (board[nX][nY] == 0) {
                        emptyCnt++;
                    } else if (myFriends.get(studentNum).contains(board[nX][nY])) {
                        friendCnt++;
                    }
                }
                candi.add(new int[]{i, j, emptyCnt, friendCnt});
            }
        }

        candi.sort((o1, o2) -> {
            if (o1[3] < o2[3]) {
                return o2[3] - o1[3];
            } else if (o1[3] == o2[3]) {
                if (o1[2] == o2[2]) {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    }
                    return o1[0] - o2[0];
                }
                return o2[2] - o1[2];
            }
            return -1;
        });

        board[candi.get(0)[0]][candi.get(0)[1]] = studentNum;
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        myFriends = new HashMap<>();

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int studentNum = Integer.parseInt(st.nextToken());
            ArrayList<Integer> myFriendsList = new ArrayList<>();

            while (st.hasMoreTokens()) {
                myFriendsList.add(Integer.parseInt(st.nextToken()));
            }

            myFriends.put(studentNum, myFriendsList);
            findLocation(studentNum);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = 0;

                for (int k = 0; k < dir.length; k++) {
                    int nX = i + dir[k][0];
                    int nY = j + dir[k][1];

                    if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
                        continue;
                    }

                    if (myFriends.get(board[i][j]).contains(board[nX][nY])) {
                        count++;
                    }
                }

                if (count != 0) {
                    res += (int) Math.pow(10, count - 1);
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
