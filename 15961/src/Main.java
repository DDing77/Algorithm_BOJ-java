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
        int R = N-1;
        int length = 0;
        while(L < N ) {
            if(length < k) {
                if(list.contains(arr[R])) {
                    list.remove(0);
                    L++;
                    list.add(arr[R]);
                } else {
                    list.add(arr[R]);
                    R++;
                    length++;
                }
            }


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
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());


    }
}
