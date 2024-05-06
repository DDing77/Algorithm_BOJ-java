import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] scoresA;
    private int[] scoresB;
    private int resMax;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            scoresA = new int[2];
            for (int j = 0; j < scoresA.length; j++) {
                scoresA[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(scoresA);

            scoresB = new int[5];
            for (int j = 0; j < scoresB.length; j++) {
                scoresB[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(scoresB);

            int sum = scoresA[scoresA.length - 1];
            for (int j = scoresB.length - 1; j >= scoresB.length - 2; j--) {
                sum += scoresB[j];
            }

            resMax = Math.max(resMax, sum);
        }
        System.out.println(resMax);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
