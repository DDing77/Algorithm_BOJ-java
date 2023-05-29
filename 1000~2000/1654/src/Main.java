import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] target;
    static int K, N;

    static void paramSearch() {
        int L = 0;
        int R = arr[0]+1;
        while (L<R) {
            int sum = 0;
            int mid = (L + R) / 2;
            for(int i=0; i<K; i++) {
                sum += arr[i]/mid;
            }
            if(sum >= N) {
                L = mid +1;
            } else {
                R = mid;
            }
        }
        System.out.println(L-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        paramSearch();
    }
}
