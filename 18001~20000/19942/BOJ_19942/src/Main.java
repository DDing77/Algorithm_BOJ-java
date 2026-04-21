import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] minValues;
    private int[][] elements;
    private boolean[] selected;
    private int resMin = Integer.MAX_VALUE;
    private ArrayList<Integer> resNumbers = new ArrayList<>();

    private boolean check(int sumP, int sumF, int sumS, int sumV) {
        return sumP >= minValues[0]
                && sumF >= minValues[1]
                && sumS >= minValues[2]
                && sumV >= minValues[3];
    }

    private void backTracking(int idx, int sumP, int sumF, int sumS, int sumV, int sumC) {
        if (sumC > resMin) {
            return;
        }

        if (check(sumP, sumF, sumS, sumV)) {
            ArrayList<Integer> currentNumbers = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (selected[i]) {
                    currentNumbers.add(i);
                }
            }

            if (resMin > sumC) {
                resMin = sumC;
                resNumbers = currentNumbers;
            }
            return;
        }

        if (idx == N) {
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!selected[i]) {
                selected[i] = true;
                backTracking(i + 1,
                        sumP + elements[i][0],
                        sumF + elements[i][1],
                        sumS + elements[i][2],
                        sumV + elements[i][3],
                        sumC + elements[i][4]);
                selected[i] = false;
            }
        }
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        minValues = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < minValues.length; i++) {
            minValues[i] = Integer.parseInt(st.nextToken());
        }

        elements = new int[N][5];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                elements[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        selected = new boolean[N];
        backTracking(0, 0, 0, 0, 0, 0);

        if (resMin == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        sb.append(resMin).append("\n");
        for (int resNumber : resNumbers) {
            sb.append(resNumber + 1).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}