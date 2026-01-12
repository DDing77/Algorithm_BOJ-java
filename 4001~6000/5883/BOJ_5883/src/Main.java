import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] arrB;
    private HashSet<Integer> set = new HashSet<>();
    private int resMax;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        arrB = new int[N];
        for (int i = 0; i < N; i++) {
            arrB[i] = Integer.parseInt(br.readLine());
            set.add(arrB[i]);
        }

        for (int banNum : set) {
            int cnt = 1;
            int cur = -1;
            for (int i = 0; i < N; i++) {
                if (arrB[i] == banNum) {
                    continue;
                }
                if (cur == arrB[i]) {
                    cnt++;
                    resMax = Math.max(resMax, cnt);
                } else {
                    resMax = Math.max(resMax, cnt);
                    cnt = 1;
                    cur = arrB[i];
                }
            }
        }
        System.out.println(resMax);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
