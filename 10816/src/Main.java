import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int lowerBound(int key) {
        int L = 0;
        int R = arr.length;
        while (L < R) {
            int mid = (L + R) / 2;
            if(key <= arr[mid]) {
                R = mid;
            } else {
                L = mid +1;
            }
        }
        return L;
    }
    static int upperBound(int key) {
        int L = 0;
        int R = arr.length;
        while (L < R) {
            int mid = (L + R) / 2;
            if(key < arr[mid]) {
                R = mid;
            } else {
                L = mid +1;
            }
        }
        return L;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());

            sb.append(upperBound( key) - lowerBound(key)).append(' ');
        }
        System.out.println(sb);
    }
}
