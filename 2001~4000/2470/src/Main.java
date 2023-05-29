import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int v1, v2;
    static int[] arr;
    static int N;
    static int binarySearch(int[] array, int l, int r, int target) {
        int result = r + 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= target) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }

    static void solution() {
        int bestSum = Integer.MAX_VALUE;
        for(int left = 0; left < N-1;left++ ) {
            int candidate = binarySearch(arr, left+1, N-1, -arr[left]);

            if(left < candidate -1 && Math.abs(arr[left] + arr[candidate -1]) < bestSum ) {
                bestSum = Math.abs(arr[left] + arr[candidate-1]);
                v1 = arr[left];
                v2 = arr[candidate-1];
            }
            if(candidate <= N-1 && Math.abs(arr[left] + arr[candidate]) < bestSum) {
                bestSum = Math.abs(arr[left] + arr[candidate]);
                v1 = arr[left];
                v2 = arr[candidate];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 0, N);
        solution();
        System.out.println(sb.append(v1).append(" ").append(v2));
    }
}
