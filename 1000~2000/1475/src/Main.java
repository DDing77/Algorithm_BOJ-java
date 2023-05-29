import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static String N;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = br.readLine();
        cnt = new int[10];

        for (int i = 0; i < N.length(); i++) {
            int cur = Integer.parseInt(String.valueOf(N.charAt(i)));
            cnt[cur % 10]++;
        }

        int sixNine = cnt[6] + cnt[9];
        if (sixNine % 2 == 0) sixNine /= 2;
        else sixNine = sixNine / 2 + 1;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) continue;
            max = Math.max(max, cnt[i]);
        }

        int res = Math.max(sixNine, max);
        System.out.println(res);
    }
}