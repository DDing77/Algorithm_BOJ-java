import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int K;
    static int N;
    static int timeSum;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        timeSum = 0;
        String status;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            timeSum += Integer.parseInt(st.nextToken());
            status = st.nextToken();

            if (timeSum >= 210) {
                System.out.println(K);
                return;
            }

            if (status.equals("T")) {
                K++;
                if (K > 8) {
                    K = 1;
                }
            }
        }

        System.out.println(K);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
