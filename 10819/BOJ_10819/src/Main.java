import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static boolean[] isVisited;
    static int[] temp;
    static int res;

    static void backTracking(int depth, int cnt) {
        if (cnt == N) {
            int sum = 0;
            for (int i = 1; i < N; i++) sum += Math.abs(temp[i - 1] - temp[i]);
            res = Math.max(res, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                temp[depth] = arr[i];
                backTracking(depth + 1, cnt + 1);
                isVisited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        isVisited = new boolean[N];
        temp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        res = 0;
        backTracking(0, 0);

        System.out.println(res);
    }
}
