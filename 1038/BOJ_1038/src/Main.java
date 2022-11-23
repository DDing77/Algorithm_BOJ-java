import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;
    static List<Integer> desc;

    private static void bt(int num, int idx) {
        if (idx > 10) return;

        desc.add(num);

        for (int i = 0; i < 10; i++) {
            if (num % 10 > i) bt(num * 10 + i, idx + 1);
        }

        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        desc = new ArrayList<>();

        if (N <= 10) System.out.println(N);
        else if (N > 1022) System.out.println(-1);
        else {
            for (int i = 0; i < 10; i++) bt(i, 1);
            Collections.sort(desc);
            System.out.println(desc.get(N));
        }
    }
}
