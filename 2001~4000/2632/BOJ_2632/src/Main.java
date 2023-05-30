import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int K;
    static int m;
    static int n;
    static int[] prefixSumA;
    static int[] prefixSumB;
    static int[] dpA;
    static int[] dpB;
    static int res;

    public static int[] getDp(int[] prefixSum, int size) {
        int[] res = new int[K + 1];

        res[0] = 1;

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size - 1; j++) {
                if (i + j - 1 <= size) {
                    if (prefixSum[i + j - 1] - prefixSum[i - 1] > K) {
                        break;
                    } else {
                        res[prefixSum[i + j - 1] - prefixSum[i - 1]]++;
                    }
                } else {
                    if (prefixSum[size] - prefixSum[i - 1] + prefixSum[i + j - 1 - size] > K) {
                        break;
                    } else {
                        res[prefixSum[size] - prefixSum[i - 1] + prefixSum[i + j - 1 - size]]++;
                    }
                }
            }
        }

        if (prefixSum[size] <= K) {
            res[prefixSum[size]]++;
        }

        return res;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        prefixSumA = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            prefixSumA[i] = prefixSumA[i - 1] + Integer.parseInt(br.readLine());
        }

        prefixSumB = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSumB[i] = prefixSumB[i - 1] + Integer.parseInt(br.readLine());
        }

        dpA = new int[K + 1];
        dpB = new int[K + 1];

        dpA = getDp(prefixSumA, m);
        dpB = getDp(prefixSumB, n);

        res = 0;
        for (int i = 0; i <= K; i++) {
            res += dpA[i] * dpB[K - i];
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
