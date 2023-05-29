import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] p;
    static ArrayList<Integer> LIA;
    static int lowerBound(ArrayList<Integer> LIA, int start, int end, int target) {
        int L = start;
        int R = end;
        while (L < R) {
            int mid = (L + R) / 2;
            if (LIA.get(mid) >= target) {
                R = mid;
            }else {
                L = mid + 1;
            }
        }
        return R;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        p = new int[N+1];
        LIA = new ArrayList<>();
        LIA.add(0);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++) {
            if(LIA.get(LIA.size()-1) < arr[i]) {
                LIA.add(arr[i]);
//                p[i] = LIA.indexOf(arr[i]);
            } else {
                int lia_idx = lowerBound(LIA, 1, LIA.size()-1, arr[i]);
                LIA.set(lia_idx, arr[i]);
//                p[i] = LIA.indexOf(arr[i]);
            }
        }
        System.out.println(LIA.size()-1);
//        for( int i=0; i< LIA.size(); i++) {
//            System.out.println(LIA.get(i));
//        }
//        System.out.println(Arrays.toString(p));
//
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(lowerBound(arr, 1, arr.length, 11));
    }
}
