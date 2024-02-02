import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    String name;
    int grade;

    private String getLetterGrade(int grade) {
        if (97 <= grade) {
            return "A+";
        } else if (90 <= grade) {
            return "A";
        } else if (87 <= grade) {
            return "B+";
        } else if (80 <= grade) {
            return "B";
        } else if (77 <= grade) {
            return "C+";
        } else if (70 <= grade) {
            return "C";
        } else if (67 <= grade) {
            return "D+";
        } else if (60 <= grade) {
            return "D";
        } else {
            return "F";
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            grade = Integer.parseInt(st.nextToken());

            sb.append(name).append(" ").append(getLetterGrade(grade)).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
