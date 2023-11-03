import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int T;
    int[] A;
    int[] B;
    int scoreA;
    int scoreB;

    public void getScoreA() {
        scoreA = A[0];
        scoreA += A[1] * 2;
        scoreA += A[2] * 3;
        scoreA += A[3] * 3;
        scoreA += A[4] * 4;
        scoreA += A[5] * 10;
    }

    public void getScoreB() {
        scoreB = B[0];
        scoreB += B[1] * 2;
        scoreB += B[2] * 2;
        scoreB += B[3] * 2;
        scoreB += B[4] * 3;
        scoreB += B[5] * 5;
        scoreB += B[6] * 10;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            A = new int[6];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < A.length; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            getScoreA();

            B = new int[7];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < B.length; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            getScoreB();

            sb.append("Battle ").append(tc).append(": ");
            if (scoreA > scoreB) {
                sb.append("Good triumphs over Evil");
            } else if (scoreA < scoreB) {
                sb.append("Evil eradicates all trace of Good");
            } else {
                sb.append("No victor on this battle field");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
