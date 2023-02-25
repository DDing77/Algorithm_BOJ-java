import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static HashMap<String, Double> scores;
    static String name, degree;
    static double score;
    static double res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        scores = new HashMap<>();
        scores.put("A+", 4.5);
        scores.put("A0", 4.0);
        scores.put("B+", 3.5);
        scores.put("B0", 3.0);
        scores.put("C+", 2.5);
        scores.put("C0", 2.0);
        scores.put("D+", 1.5);
        scores.put("D0", 1.0);
        scores.put("F", 0.0);

        res = 0;
        int cnt = 0;
        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            score = Double.parseDouble(st.nextToken());
            degree = st.nextToken();

            if (degree.equals("P")) {
                continue;
            }

            cnt += score;
            res += scores.get(degree) * score;
        }

        res /= cnt;

        System.out.println(res);
    }
}