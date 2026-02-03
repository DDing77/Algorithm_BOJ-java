import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int LENGTH = 10;

    private int[] answerArr = new int[LENGTH];
    private int[] myAnswerArr = new int[LENGTH];
    private int res;

    private void execDFS(int idx, int count) {
        if (count + LENGTH - idx < 5) {
            return;
        }
        if (idx == LENGTH) {
            if (count >= 5) {
                res++;
                return;
            }
        }

        boolean isTwo = false;
        if (idx > 1 && myAnswerArr[idx - 1] == myAnswerArr[idx - 2]) {
            isTwo = true;
        }

        for (int i = 1; i <= 5; i++) {
            if (isTwo && myAnswerArr[idx - 1] == i) {
                continue;
            }
            myAnswerArr[idx] = i;
            if (answerArr[idx] == myAnswerArr[idx]) {
                execDFS(idx + 1, count + 1);
            } else {
                execDFS(idx + 1, count);
            }
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < LENGTH; i++) {
            answerArr[i] = Integer.parseInt(st.nextToken());
        }

        execDFS(0, 0);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
