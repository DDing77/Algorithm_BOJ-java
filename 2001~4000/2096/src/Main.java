import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] maxDP, minDP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        maxDP = new int[3];
        minDP = new int[3];
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int cur = Integer.parseInt(st.nextToken());
            maxDP[i] = cur;
            minDP[i] = cur;
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int inputA = Integer.parseInt(st.nextToken());
            int inputB = Integer.parseInt(st.nextToken());
            int inputC = Integer.parseInt(st.nextToken());
            int temp_0 = maxDP[0];
            int temp_2 = maxDP[2];
            maxDP[0] = Math.max(maxDP[0], maxDP[1]) + inputA;
            maxDP[2] = Math.max(maxDP[1], maxDP[2]) + inputC;
            maxDP[1] = Math.max(Math.max(temp_0, maxDP[1]), temp_2) + inputB;

            temp_0 = minDP[0];
            temp_2 = minDP[2];
            minDP[0] = Math.min(minDP[0], minDP[1]) + inputA;
            minDP[2] = Math.min(minDP[1], minDP[2]) + inputC;
            minDP[1] = Math.min(Math.min(temp_0, minDP[1]), temp_2) + inputB;
        }
        sb.append(Math.max(Math.max(maxDP[0], maxDP[1]), maxDP[2])).append(" ");
        sb.append(Math.min(Math.min(minDP[0], minDP[1]), minDP[2]));
        System.out.println(sb);
//        System.out.println(Math.max(Math.max(maxDP[0], maxDP[1]), maxDP[2]) + " " + Math.min(Math.min(minDP[0], minDP[1]), minDP[2]));
    }
}
