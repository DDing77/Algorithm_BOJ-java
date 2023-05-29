import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] A;
    static int[] BIDx;
    static int[] res;
    static int[] lisIdx;
    static ArrayList<Integer> LIS;

    static int lowerBound(int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) >> 1;
            if (LIS.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        BIDx = new int[N];
        res = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) BIDx[Integer.parseInt(st.nextToken()) - 1] = i;

        for (int i = 0; i < N; i++) res[i] = BIDx[A[i] - 1] + 1;

        LIS = new ArrayList<>();
        LIS.add(0);

        for (int i = 0; i < N; i++) {
            if (LIS.get(LIS.size() - 1) < res[i]) {
                LIS.add(res[i]);
            } else {
                int lisIdx = lowerBound(1, LIS.size() - 1, res[i]);
                LIS.set(lisIdx, res[i]);
            }
        }

        System.out.println(LIS.size() - 1);
    }
}
