import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int T, n, m;
    static int[] A, B;
    static ArrayList<Integer> sumA, sumB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        n = Integer.parseInt(br.readLine());
        A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        sumA = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                sumA.add(sum);
            }
        }
        Collections.sort(sumA);

        sumB = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                sumB.add(sum);
            }
        }
        Collections.sort(sumB);

        long ans = 0;
        int L = 0;
        int R = sumB.size() - 1;

        while (L < sumA.size() && R >= 0) {
            long curSum = sumA.get(L) + sumB.get(R);
            if (curSum == T) {
                long a = 0, b = 0;
                long curA = sumA.get(L);
                long curB = sumB.get(R);
                while (L < sumA.size() && sumA.get(L) == curA) {
                    L++;
                    a++;
                }
                while (R >= 0 && sumB.get(R) == curB) {
                    R--;
                    b++;
                }
                ans += (a * b);
            } else if(curSum < T){
                L++;
            } else {
                R--;
            }
        }
        System.out.println(ans);
    }
}
