import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    int N;
    int K;

    private int getPercent(int rank) {
        return (rank * 100) / N;
    }

    private int getRank(int grade) {
        if (96 < grade && grade <= 100) {
            return 9;
        } else if (89 < grade && grade <= 96) {
            return 8;
        } else if (77 < grade && grade <= 89) {
            return 7;
        } else if (60 < grade && grade <= 77) {
            return 6;
        } else if (40 < grade && grade <= 60) {
            return 5;
        } else if (23 < grade && grade <= 40) {
            return 4;
        } else if (11 < grade && grade <= 23) {
            return 3;
        } else if (4 < grade && grade <= 11) {
            return 2;
        } else if (0 <= grade && grade <= 4) {
            return 1;
        }

        return -1;
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int percent;
        int grade;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            percent = getPercent(Integer.parseInt(st.nextToken()));
            grade = getRank(percent);
            sb.append(grade).append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
