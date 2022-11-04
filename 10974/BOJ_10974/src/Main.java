import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int arr[];
    static boolean isVisited[];
    static StringBuilder sb;

    static void backTracking(int cnt) {
        if (cnt == N) {
            for (int i = 0; i < N; i++) sb.append(arr[i] + " ");
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) {
                arr[cnt] = i + 1;
                isVisited[i] = true;
                backTracking(cnt + 1);
                isVisited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        isVisited = new boolean[N];

        backTracking(0);

        System.out.print(sb);
    }
}