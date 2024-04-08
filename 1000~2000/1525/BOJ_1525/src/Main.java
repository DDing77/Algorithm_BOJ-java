import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final String answerString = "123456780";
    static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] board;
    Map<String, Integer> map;

    private int execBFS(String startBoard) {

        map = new HashMap<>();
        Queue<String> que = new ArrayDeque<>();
        que.add(startBoard);
        map.put(startBoard, 0);

        while (!que.isEmpty()) {
            String cur = que.poll();

            if (answerString.equals(cur)) {
                return map.get(cur);
            }

            int zeroIdx = cur.indexOf("0");
            int curX = zeroIdx / 3;
            int curY = zeroIdx % 3;

            for (int i = 0; i < dir.length; i++) {
                int nX = curX + dir[i][0];
                int nY = curY + dir[i][1];

                if (nX < 0 || nX >= 3 || nY < 0 || nY >= 3) {
                    continue;
                }

                int nextZeroIdx = nX * 3 + nY;
                char nextChar = cur.charAt(nextZeroIdx);

                StringBuilder temp = new StringBuilder(cur);
                temp.setCharAt(zeroIdx, nextChar);
                temp.setCharAt(nextZeroIdx, '0');

                if (map.containsKey(temp.toString())) {
                    continue;
                }

                que.add(temp.toString());
                map.put(temp.toString(), map.get(cur) + 1);
            }
        }

        return -1;
    }

    private void solution() throws IOException {

        StringBuilder startBoard = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                startBoard.append(st.nextToken());
            }
        }

        System.out.println(execBFS(startBoard.toString()));
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
