import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public HashMap<String, Double> gradeMap;

    private int N;
    private double total;
    private double average;

    private void initGradeMap() {

        gradeMap = new HashMap<>();
        gradeMap.put("A+", 4.3);
        gradeMap.put("A0", 4.0);
        gradeMap.put("A-", 3.7);
        gradeMap.put("B+", 3.3);
        gradeMap.put("B0", 3.0);
        gradeMap.put("B-", 2.7);
        gradeMap.put("C+", 2.3);
        gradeMap.put("C0", 2.0);
        gradeMap.put("C-", 1.7);
        gradeMap.put("D+", 1.3);
        gradeMap.put("D0", 1.0);
        gradeMap.put("D-", 0.7);
        gradeMap.put("F", 0.0);
    }

    private void solution() throws IOException {

        initGradeMap();

        N = Integer.parseInt(br.readLine());
        total = 0.0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            int credit = Integer.parseInt(st.nextToken());
            total += credit;
            String grade = st.nextToken();
            average += credit * gradeMap.get(grade);
        }

        System.out.printf("%.2f%n", average / total);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
