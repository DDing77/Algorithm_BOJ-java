import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Student {
        /* man : 1 , woman : 2 */
        int sex;
        int number;

        public Student(int sex, int number) {
            this.sex = sex;
            this.number = number;
        }
    }

    static int N, M;
    static int[] status;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        status = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) status[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int switchNum = Integer.parseInt(st.nextToken());

            // man
            if (sex == 1) {
                for (int j = switchNum; j <= N; j++) {
                    if (j % switchNum == 0) status[j] = status[j] == 0 ? 1 : 0;
                }
            } else {
                status[switchNum] = status[switchNum] == 0 ? 1 : 0;
                int left = switchNum - 1;
                int right = switchNum + 1;
                while (left > 0 && right <= N && status[left] == status[right]) {
                    status[left] = status[left] == 0 ? 1 : 0;
                    status[right] = status[right] == 0 ? 1 : 0;
                    left--;
                    right++;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            sb.append(status[i] + " ");
            if (i % 20 == 0) sb.append('\n');
        }
        System.out.println(sb);
    }
}
