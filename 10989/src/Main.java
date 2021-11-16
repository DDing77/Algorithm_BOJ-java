import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] arr;
    static int[] sorted;

    static void mergeSort(int[] arr) {
        sorted = new int[arr.length];
        divide(arr, 0, arr.length-1);
    }

    static void divide(int[] arr, int left, int right) {
        int mid = (left + right) / 2;

        if(left == right) return;

        divide(arr, left, mid);
        divide(arr, mid+1, right);
        merge(arr,left,mid,right);

    }

    static void merge(int[] arr, int left, int mid, int right) {
        int l = left;
        int r = mid +1;
        int idx = left;
        while(l <= mid && r <= right) {
            if(arr[l] <= arr[r]) {
                sorted[idx] = arr[l];
                idx++;
                l++;
            } else {
                sorted[idx] = arr[r];
                idx++;
                r++;
            }
        }
        if(l>mid) {
            while(r<=right) {
                sorted[idx] = arr[r];
                idx++;
                r++;
            }
        } else {
            while(l<=mid) {
                sorted[idx] =arr[l];
                idx++;
                l++;
            }
        }
        for(int i=left; i<=right; i++) {
            arr[i] = sorted[i];
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr);

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append('\n');
        }
        System.out.println(sb.toString());
    }
}
