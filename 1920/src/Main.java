import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void binary_search(int start, int end, int target) {
        if(start <= end) {
            int mid = (start + end) / 2;
            if (target == arr[mid]) {
                sb.append(1).append('\n');
                return;
            }
            if (target < arr[mid]) {
                binary_search(start, mid-1, target);
            }
            if (target > arr[mid]) {
                binary_search(mid+1, end, target);
            }
        }
        if(start> end) {
            sb.append(0).append('\n');
            return;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            binary_search(0, arr.length-1, Integer.parseInt(st.nextToken()));
        }
        System.out.print(sb);
    }
}
