import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// author : DDing
// solution : LIS(LDS)

public class Main {
    static int N;
    static int[] arr;
    static int[] p;
    static ArrayList<Integer> list;
    static int lowerBound(ArrayList<Integer> list, int target) {
        int L = 0;
        int R = list.size()-1;
        while(L<R) {
            int mid = (L+R) /2;
            if( list.get(mid) >= target) {
                R = mid;
            }else {
                L = mid +1;
            }
        }
        return R;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr= new int[N+1];
        p = new int[N+1];
        list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());

        list.add(0);
        for(int i=N; i>=1; i--) {
            if(list.get(list.size()-1) < arr[i]) {
                list.add(arr[i]);
                p[i] = list.size()-1;
            }else {
                int lia_idx = lowerBound(list, arr[i]);
                list.set(lia_idx, arr[i]);
                p[i] = lia_idx;
            }
        }
//        System.out.println(list);
//        System.out.println(Arrays.toString(p));
        System.out.println(list.size()-1);

    }
}