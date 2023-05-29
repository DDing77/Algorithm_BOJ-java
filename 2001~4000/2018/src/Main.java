import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N ==1) {
            System.out.println(1);
            return;
        }
        arr = new int[N + 1];

        for (int i = 0; i <= N; i++) arr[i] = i;

        int L = 1;
        int R = 1;
        long sum = arr[1];
        int cnt = 0;
        while (R < N && L <= R) {
            if (sum < N) {
                R++;
                sum += arr[R];
            }
            if (sum > N) {
                sum -= arr[L];
                L++;
            }
            if(sum == N) {
//                System.out.println("L : " + L + " R : " + R);
                cnt++;
                sum-=arr[L];
                L++;
            }
        }
        System.out.println(cnt);
    }
}
