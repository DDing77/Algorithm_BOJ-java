import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int K;

    private int neededLights(int length, int range) {
        return (length + range - 1) / range;
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        int coverLength = 2 * K + 1;
        int covered = 0;
        int answer = 0;

        for (int i = 0; i < M; i++) {
            int pos = Integer.parseInt(br.readLine());

            int left = Math.max(1, pos - K);
            int right = Math.min(N, pos + K);

            if (covered + 1 < left) {
                int gapLength = left - covered - 1;
                answer += neededLights(gapLength, coverLength);
            }

            if (covered < right) {
                covered = right;
            }
        }

        if (covered < N) {
            int gapLength = N - covered;
            answer += neededLights(gapLength, coverLength);
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}