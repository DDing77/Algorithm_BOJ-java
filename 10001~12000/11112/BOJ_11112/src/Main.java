import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private static final int SIZE = 3;
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int T;
    private Map<String, Integer> answers;

    private int[] getOrderToIdx(int order) {
        return new int[]{order / SIZE, order % SIZE};
    }

    private int getIdxToOrder(int[] idx) {
        return idx[0] * SIZE + idx[1];
    }

    private void getAnswers() {
        Queue<Info> que = new ArrayDeque<>();
        String answerStr = "123456789";
        que.add(new Info(answerStr, 8, 0));
        answers = new HashMap<>();
        answers.put(answerStr, 0);

        while (!que.isEmpty()) {
            Info info = que.poll();
            int[] curIdx = getOrderToIdx(info.order);

            for (int[] dir : dirs) {
                int nX = curIdx[0] + dir[0];
                int nY = curIdx[1] + dir[1];

                if (nX < 0 || nX >= SIZE || nY < 0 || nY >= SIZE) {
                    continue;
                }

                char[] nStatusArr = info.status.toCharArray();
                int nOrder = getIdxToOrder(new int[]{nX, nY});

                char temp = nStatusArr[info.order];
                nStatusArr[info.order] = nStatusArr[nOrder];
                nStatusArr[nOrder] = temp;

                String nStatusStr = new String(nStatusArr);
                if (answers.containsKey(nStatusStr)) {
                    continue;
                }

                answers.put(nStatusStr, info.moveCnt + 1);
                que.add(new Info(nStatusStr, nOrder, info.moveCnt + 1));
            }
        }
    }

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        getAnswers();

        while (T-- > 0) {
            br.readLine();
            StringBuilder status = new StringBuilder();
            for (int i = 0; i < SIZE; i++) {
                String input = br.readLine();
                for (int j = 0; j < input.length(); j++) {
                    char c = input.charAt(j);
                    if (c == '#') {
                        c = '9';
                    }
                    status.append(c);
                }
            }
            int resCnt = answers.getOrDefault(status.toString(), -1);
            if (resCnt == -1) {
                sb.append("impossible");
            } else {
                sb.append(resCnt);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Info {

        String status;
        int order;
        int moveCnt;

        public Info(String status, int order, int moveCnt) {
            this.status = status;
            this.order = order;
            this.moveCnt = moveCnt;
        }
    }
}
