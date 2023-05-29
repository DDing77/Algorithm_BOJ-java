import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[][] student;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        student = new int[7][2];

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            student[grade][sex]++;
        }

        int res = 0;
        for (int i = 0; i < student.length; i++) {
            for (int j = 0; j < 2; j++) {
                res += student[i][j] / K;
                if (student[i][j] % K > 0) res++;
            }
        }
        System.out.println(res);
    }
}