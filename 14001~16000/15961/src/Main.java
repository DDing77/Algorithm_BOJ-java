import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, d, k, c;
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    static boolean isExist = false;
    static ArrayList<Integer> list = new ArrayList<>();

    static void twoPointer() {
        int L = 0;
        int R = 0;
        int length = 0;
        int cnt = 0;
        while (L < N) {
            if (length < k) {
                if (list.contains(arr[R])) {
                    list.add(arr[R]);
                    R++;
                    length++;
                } else if(!list.contains(arr[R])){
                    list.add(arr[R]);
                    R++;
                    cnt++;
                    length++;
                    max = Math.max(max,cnt);
                    if (list.size() == k && !list.contains(c)) cnt += 1;
                }

            } else {
//                System.out.println(list + ", " + cnt);
                int temp = list.remove(0);
                if(!list.contains(temp)) {
                    cnt--;
//                    System.out.println("test , " + cnt);
                }
                L++;
                if (list.contains(arr[R % N])) {
                    list.add(arr[R % N]);
                    R++;
                } else {
                    list.add(arr[R % N]);
                    cnt++;
                    R++;
                }
                max = Math.max(max, cnt);

            }
            if (!list.contains(c)) max = Math.max(max, cnt + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        twoPointer();
        System.out.println(max);
    }
}
