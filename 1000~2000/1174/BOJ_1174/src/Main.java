import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static final int[] num = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static int N;
    static long sum;
    static ArrayList<Long> res;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        res = new ArrayList<>();

        for (int i = 1; i < (1 << 10); i++) {
            sum = 0;
            for (int j = 0; j < 10; j++) {
                if ((i & (1 << j)) >= 1) {
                    sum = sum * 10 + num[j];
                }
            }
            res.add(sum);
        }

        Collections.sort(res);

        if (res.size() < N) {
            System.out.println(-1);
            return;
        }

        System.out.println(res.get(N - 1));
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
