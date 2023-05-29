import javax.crypto.Cipher;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static int[] arr;
    static int res = 0;
    static int searchIdx = -1;
    static ArrayList<Integer> leftList = new ArrayList<>();
    static ArrayList<Integer> rightList = new ArrayList<>();

    static void bruteForce(int idx, int sum, int limit, ArrayList<Integer> list) {
        if (sum > C) return;
        if (idx == limit) {
            list.add(sum);
            return;
        }
        bruteForce(idx + 1, sum, limit, list);
        bruteForce(idx + 1, sum + arr[idx], limit, list);
    }
    static void binarySearch(int start, int end, int target) {
        int left = start;
        int right = end;
        while(left <= right) {
            int mid = (left + right) /2;
            if( C >= target + rightList.get(mid)) {
                left = mid+1;
                searchIdx = mid;
            } else {
                right = mid -1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr= new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        bruteForce(0, 0, N / 2, leftList);
        bruteForce(N / 2, 0, N, rightList);
        Collections.sort(rightList);

        for(int i=0; i< leftList.size(); i++) {
            searchIdx = -1;
            binarySearch(0, rightList.size()-1, leftList.get(i));
            res += searchIdx + 1;
        }
        System.out.println(res);
    }
}
