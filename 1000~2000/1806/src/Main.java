import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int S;

    static void getAns() {
        int L = 0, R = 0, len = 100001, sum = 0;
        while (true) {
            if (sum >= S) {
                sum -= arr[L++];
                len = Math.min(len, (R - L) + 1);
            } else if (R == arr.length) {
                break;
            } else {
                sum += arr[R++];
            }
        }
        if (len == 100001) System.out.println(0);
        else System.out.println(len);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        getAns();
    }
}
