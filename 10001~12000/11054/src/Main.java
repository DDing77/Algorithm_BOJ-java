import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// author : DDing
// solution : LIS, LDS

public class Main {
    static int N;
    static int[] arr;
    static int[] lrDP;
    static int[] rlDP;
    static ArrayList<Integer> lrLIA;
    static ArrayList<Integer> rlLIA;
    static int lowerBound(ArrayList<Integer> list, int target) {
        int L = 0;
        int R = list.size()-1;
        while(L < R) {
            int mid = (L + R) /2;
            if(list.get(mid) >= target) {
                R = mid;
            }
            else {
                L = mid+1;
            }
        }
        return R;
    }
    static int upperBound(ArrayList<Integer> list, int target) {
        int L = 0;
        int R = list.size()-1;
        while(L < R) {
            int mid = (L + R) /2;
            if(list.get(mid) <= target) {
                L = mid+1;
            }
            else {
                R = mid;
            }
        }
        return R;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        lrLIA = new ArrayList<>();
        rlLIA = new ArrayList<>();
        lrDP = new int[N+1];
        rlDP = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // L to R
        lrLIA.add(0);
        for(int i=1; i<=N; i++) {
            if(lrLIA.get(lrLIA.size()-1) < arr[i]) {
                lrLIA.add(arr[i]);
                lrDP[i] = lrLIA.size()-1;
            } else {
                int lia_idx = lowerBound(lrLIA, arr[i]);
                lrLIA.set(lia_idx, arr[i]);
                lrDP[i] = lia_idx;
            }
        }
//        System.out.println(lrLIA.size()-1);
//        System.out.println(Arrays.toString(lrDP));

        // R to L
        rlLIA.add(0);
        for(int i=N; i>=1; i--) {
            if(rlLIA.get(rlLIA.size()-1) < arr[i]) {
                rlLIA.add(arr[i]);
                rlDP[i] = rlLIA.size()-1;
            }else {
                int lia_idx = lowerBound(rlLIA, arr[i]);
                rlLIA.set(lia_idx, arr[i]);
                rlDP[i] = lia_idx;
            }
        }
//        System.out.println(rlLIA.size()-1);
//        System.out.println(Arrays.toString(rlDP));
        int max = -1;
        for(int i=0; i<=N; i++) {
            rlDP[i] = rlDP[i]+ lrDP[i];
            max = Math.max(max, rlDP[i]);
        }
//        System.out.println(Arrays.toString(rlDP));
        System.out.println(max-1);
    }
}
