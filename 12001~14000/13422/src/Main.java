import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, N, M, K;
    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            house = new int[N];

            st = new StringTokenizer(br.readLine());
            long sum = 0;
            for (int i = 0; i < N; i++) {
                house[i] = Integer.parseInt(st.nextToken());
                sum += house[i];
            }

            if (N == M) {
                if (sum < K) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            } else {
                int length = 0;
                int L = 0;
                int R = 0;
                long curSum = 0;
                int res = 0;
                while (L < N) {
                    if (length < M) {
                        curSum += house[R];
                        R++;
                        length++;

                    } else {
                        if (curSum < K) {
//                            System.out.println("L : " + L + " R : " + R);
//                            System.out.println("test : "  + curSum);
                            res++;
                        }
                        curSum += house[R % N];
                        ++R;
                        curSum -= house[L];
                        L++;
                    }
                }
                sb.append(res).append('\n');
            }
        }
        System.out.print(sb);
    }
}
