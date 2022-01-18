import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int sum;
    static int[] arr;
    static int cnt =0;
    static void twoPointer() {
        sum = arr[0];
        int L = 0, R = 0;
        while (true) {
            if(sum == M) {
                cnt++;
                sum -= arr[L++];
            }
            else if(sum >M) {
                sum -= arr[L++];
            }
            else { // 적을때
                R++;
                if(R==N) break;
                sum += arr[R];

            }
//            System.out.println("L : "+L);
//            System.out.println("R : " +R);
//            System.out.println("sum " +sum);
//            System.out.println("cnt " + cnt);
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        twoPointer();
    }
}
