import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, T;
    static int[] arr, temp;
    static long oprCnt;
    static StringBuilder sb = new StringBuilder();

    static boolean isPossible(int mid) {
        oprCnt = 0;
        temp = arr.clone();
        for (int i = 0; i < N - 1; i++) {
            if (temp[i + 1] - temp[i] > mid) {
                oprCnt += temp[i + 1] - (temp[i] + mid);
                temp[i + 1] = temp[i] + mid;
            }
        }

        for (int i = N - 1; i > 0; i--) {
            if (temp[i - 1] - temp[i] > mid) {
                oprCnt += temp[i - 1] - (temp[i] + mid);
                temp[i - 1] = temp[i] + mid;
            }
        }
        return oprCnt <= T ? true : false;
    }

    static void print(int mid) {
        for (int i = 0; i < N - 1; i++) {
            if (arr[i + 1] - arr[i] > mid) arr[i + 1] = arr[i] + mid;
        }

        for (int i = N - 1; i > 0; i--) {
            if (arr[i - 1] - arr[i] > mid) arr[i - 1] = arr[i] + mid;
        }

        for (int i = 0; i < N; i++) sb.append(arr[i]).append(" ");
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 1000000000;

        while (left < right) {
            int mid = (left + right) >> 1;
            if (isPossible(mid)) right = mid;
            else left = mid + 1;
        }
        print(right);
    }
}
