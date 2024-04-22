import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static final int TOTAL_GAME_SECOND = 48 * 60;

    int N;
    ArrayDeque<Integer> dqA;
    ArrayDeque<Integer> dqB;
    int totalA;
    int totalB;

    private String convertSecondToString(int totalTime) {

        int min = totalTime / 60;
        int second = totalTime % 60;

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d", min)).append(":").append(String.format("%02d", second));
        return sb.toString();
    }

    private int convertStringToSecond(String timeString) {

        String[] time = timeString.split(":");
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }

    private void solution() throws IOException {

        dqA = new ArrayDeque<>();
        dqB = new ArrayDeque<>();
        totalA = 0;
        totalB = 0;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            int second = convertStringToSecond(st.nextToken());

            if (team == 1) {
                dqA.addLast(second);
                if (dqA.size() == dqB.size()) {
                    totalB += dqA.peekLast() - dqB.peekFirst();
                    dqA.clear();
                    dqB.clear();
                }
            } else {
                dqB.addLast(second);
                if (dqA.size() == dqB.size()) {
                    totalA += dqB.peekLast() - dqA.peekFirst();
                    dqA.clear();
                    dqB.clear();
                }
            }
        }

        if (dqA.size() > dqB.size()) {
            totalA += TOTAL_GAME_SECOND - dqA.peekFirst();
        } else if (dqA.size() < dqB.size()) {
            totalB += TOTAL_GAME_SECOND - dqB.peekFirst();
        }

        sb.append(convertSecondToString(totalA)).append("\n").append(convertSecondToString(totalB));
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
