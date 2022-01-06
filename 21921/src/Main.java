import java.io.*;
import java.util.*;

public class Main {
    static int N, X;
    static int[] arr;
    static int sum = 0, cnt = 1, maxVisit = 0;

    static void windowSliding() {
        int L = 1, R = 1;
        while (R <= N) {
            if (R <= X) {
                sum += arr[R];
                maxVisit = sum;
                R++;
            }
            if (R > X) {
                sum -= arr[L];
                L++;
                sum += arr[R];
                R++;
                if (maxVisit == sum) cnt++;
                if  (sum>maxVisit ) cnt = 1;
                maxVisit = Math.max(sum, maxVisit);
            }
        }
        if(maxVisit == 0) System.out.println("SAD");
        else {
            System.out.println(maxVisit);
            System.out.println(cnt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        windowSliding();
    }
}
