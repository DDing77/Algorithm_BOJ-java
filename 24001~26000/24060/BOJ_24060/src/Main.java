import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    int N;
    int K;
    int[] arr;
    int[] temp;
    int res;
    int cnt;

    public void merge(int l, int mid, int r) {
        int idx = 0;
        int i = l;
        int j = mid + 1;

        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[idx++] = arr[i++];
            } else {
                temp[idx++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[idx++] = arr[i++];
        }
        while (j <= r) {
            temp[idx++] = arr[j++];
        }

        i = l;
        idx = 0;
        while (i <= r) {
            arr[i++] = temp[idx++];
            cnt++;
            if (cnt == K) {
                res = arr[i - 1];
                return;
            }
        }
    }

    public void mergeSort(int l, int r) {
        if (l < r) {
            int mid = (l + r) >> 1;
            mergeSort(l, mid);
            mergeSort(mid + 1, r);
            merge(l, mid, r);
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        cnt = 0;
        res = -1;
        temp = new int[N];
        mergeSort(0, N - 1);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
