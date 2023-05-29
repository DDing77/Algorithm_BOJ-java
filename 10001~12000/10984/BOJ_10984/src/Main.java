import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int N;
    static int grade;
    static double score;
    static int gradeSum;
    static double scoreSum;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            gradeSum = 0;
            scoreSum = 0;

            while (N-- > 0) {
                st = new StringTokenizer(br.readLine());
                grade = Integer.parseInt(st.nextToken());
                score = Double.parseDouble(st.nextToken());

                gradeSum += grade;
                scoreSum += grade * score;
            }

            sb.append(gradeSum + " " + String.format("%.1f", (scoreSum / gradeSum))).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
